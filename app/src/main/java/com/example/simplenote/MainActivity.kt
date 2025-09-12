package com.example.simplenote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenote.data.local.TokenManager
import com.example.simplenote.data.local.database.AppDatabase
import com.example.simplenote.data.repository.LocalNoteRepository
import com.example.simplenote.data.repository.LocalUserRepository
import com.example.simplenote.data.remote.RetrofitInstance
import com.example.simplenote.data.repository.AuthRepository
import com.example.simplenote.data.repository.NoteRepository
import com.example.simplenote.data.repository.SettingsRepository
import com.example.simplenote.data.sync.SyncManager
import com.example.simplenote.presentation.auth.AuthViewModel
import com.example.simplenote.presentation.auth.AuthViewModelFactory
import com.example.simplenote.presentation.auth.ChangePasswordViewModel
import com.example.simplenote.presentation.auth.ChangePasswordViewModelFactory
import com.example.simplenote.presentation.home.AddNoteViewModel
import com.example.simplenote.presentation.home.AddNoteViewModelFactory
import com.example.simplenote.presentation.home.HomeViewModel
import com.example.simplenote.presentation.home.HomeViewModelFactory
import com.example.simplenote.presentation.navigation.AppScreens
import com.example.simplenote.presentation.settings.SettingsViewModel
import com.example.simplenote.presentation.settings.SettingsViewModelFactory
import com.example.simplenote.presentation.ui.*
import com.example.simplenote.ui.theme.SimpleNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val tokenManager = TokenManager(applicationContext)
        RetrofitInstance.init(tokenManager)
        
        // Initialize database and repositories with error handling
        val database = try {
            AppDatabase.getDatabase(applicationContext)
        } catch (e: Exception) {
            null
        }
        
        val localNoteRepository = database?.let { LocalNoteRepository(it.noteDao()) }
        val localUserRepository = database?.let { LocalUserRepository(it.userDao(), it.userCredentialsDao()) }
        val syncManager = try {
            SyncManager(applicationContext)
        } catch (e: Exception) {
            null
        }
        
        val authRepository = AuthRepository(RetrofitInstance.api, tokenManager, localUserRepository, syncManager)
        val authViewModel = AuthViewModelFactory(authRepository).create(AuthViewModel::class.java)

        setContent {
            SimpleNoteTheme {
                val noteRepository = NoteRepository(RetrofitInstance.noteApi, localNoteRepository, syncManager)
                val homeViewModelFactory = HomeViewModelFactory(noteRepository)
                val homeViewModel = homeViewModelFactory.create(HomeViewModel::class.java)

                val addNoteViewModel = AddNoteViewModelFactory(noteRepository).create(AddNoteViewModel::class.java)

                val settingsRepo = SettingsRepository(RetrofitInstance.api, authRepository)
                val settingsViewModelFactory = SettingsViewModelFactory(settingsRepo, authRepository)
                val settingsViewModel = settingsViewModelFactory.create(SettingsViewModel::class.java)

                val changePasswordViewModel = ChangePasswordViewModelFactory(settingsRepo).create(ChangePasswordViewModel::class.java)

                // Observe auth state and render the appropriate graph.
                val token by tokenManager.accessTokenFlow.collectAsState()
                val isAuthenticated = token != null
                
                // Set user context when authenticated
                LaunchedEffect(isAuthenticated) {
                    if (isAuthenticated) {
                        try {
                            val userInfo = authRepository.setCurrentUserContext()
                            noteRepository.setCurrentUser(userInfo.id)
                        } catch (e: Exception) {
                            // Handle error if needed
                        }
                    }
                }

                androidx.compose.runtime.key(isAuthenticated) {
                    val navController = rememberNavController()
                    val startDestination = if (isAuthenticated) AppScreens.Home.route else AppScreens.Onboarding.route

                    NavHost(navController = navController, startDestination = startDestination) {
                        composable(AppScreens.Onboarding.route) {
                            OnboardingScreen(onGetStarted = { navController.navigate(AppScreens.Login.route) })
                        }
                        composable(AppScreens.Login.route) {
                            LoginScreen(
                                viewModel = authViewModel,
                                onRegister = { navController.navigate(AppScreens.Register.route) },
                                onForgotPassword = { navController.navigate(AppScreens.ResetPassword.route) },
                                onLoginSuccess = { /* No-op: token change will switch graph */ }
                            )
                        }
                        composable(AppScreens.Register.route) {
                            RegisterScreen(
                                viewModel = authViewModel,
                                onLoginClick = { navController.navigate(AppScreens.Login.route) },
                                onRegisterSuccess = { /* No-op: we will switch graph after login */ }
                            )
                        }
                        composable(AppScreens.ResetPassword.route) {
                            ResetPasswordScreen(onResetSuccess = { navController.navigate(AppScreens.Login.route) })
                        }
                        composable(AppScreens.Home.route) {
                            HomeScreen(
                                viewModel = homeViewModel,
                                onAddNoteClick = { navController.navigate(AppScreens.AddNote.route) },
                                onSettingsClick = { navController.navigate(AppScreens.Settings.route) },
                                onNoteClick = { noteId -> navController.navigate("note_detail/$noteId") },
                                syncManager = syncManager
                            )
                        }
                        composable(AppScreens.NoteList.route) {
                            NoteListScreen(onNoteClick = { noteId -> navController.navigate("note_detail/$noteId") })
                        }
                        composable("note_detail/{noteId}") { backStackEntry ->
                            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()
                            noteId?.let {
                                NoteDetailScreen(
                                    noteId = it,
                                    viewModel = homeViewModel,
                                    onBack = { navController.popBackStack() }
                                )
                            }
                        }
                        composable(AppScreens.AddNote.route) {
                            AddNoteScreen(
                                viewModel = addNoteViewModel,
                                onNoteSaved = {
                                    homeViewModel.refreshNotes()
                                    navController.navigate(AppScreens.Home.route) {
                                        launchSingleTop = true
                                        popUpTo(AppScreens.Home.route) { inclusive = false }
                                    }
                                },
                                onBackPressed = { navController.popBackStack() }
                            )
                        }
                        composable(AppScreens.Settings.route) {
                            SettingsScreen(
                                onBackClick = { navController.popBackStack() },
                                onChangePasswordClick = { navController.navigate(AppScreens.ChangePassword.route) },
                                onLogoutClick = { 
                                    // Clear tokens to trigger authentication state change
                                    tokenManager.clearTokens()
                                },
                                viewModel = settingsViewModel
                            )
                        }
                        composable(AppScreens.ChangePassword.route) {
                            ChangePasswordScreen(
                                onBack = { navController.popBackStack() },
                                viewModel = changePasswordViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}

// Unchanged Greeting and Preview functions...
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleNoteTheme {
        Greeting("Android")
    }
}