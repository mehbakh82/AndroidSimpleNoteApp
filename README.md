# Simple Note

A modern, offline-first Android note-taking application built with Jetpack Compose and clean architecture principles. The application provides seamless note management with robust offline capabilities, automatic synchronization, and a modern Material 3 user interface.

## Overview

Simple Note is designed as an offline-first application that ensures users can create, edit, and manage their notes even without internet connectivity. The app automatically synchronizes data when network connectivity is restored, providing a seamless user experience across different network conditions.

## Features

### Complete Feature List
The application provides the following core features:

- ✅ **User Registration and Login**: Complete authentication system with registration and login forms
- ✅ **View List of Notes**: Paginated note list with efficient loading and display
- ✅ **Search Within Notes**: Real-time search functionality across note titles and content
- ✅ **View Note Details**: Dedicated screen for viewing individual note details
- ✅ **Manage Notes**: Full CRUD operations (Create, Read, Update, Delete) for notes
- ✅ **View Profile and Log Out**: User profile management with secure logout functionality
- ✅ **Authentication Token Refresh**: Automatic JWT token refresh mechanism using refresh tokens
- ✅ **Offline-First Functionality**: Complete offline support using local Room database

### Core Functionality
- **Note Management**: Complete CRUD operations for notes (Create, Read, Update, Delete)
- **Note List View**: View paginated list of all user notes with efficient loading
- **Note Details**: View individual note details in a dedicated screen
- **Search Functionality**: Real-time search across note titles and content with debounced input
- **Pagination Support**: Efficient loading of notes with pagination for large datasets
- **Offline-First Architecture**: Complete functionality available without internet connectivity
- **Automatic Synchronization**: Seamless data sync when network connectivity is restored

### User Authentication & Profile
- **User Registration**: Complete user registration with form validation
- **User Login**: Secure login with username/password authentication
- **Profile Management**: View user profile information and account details
- **Logout Functionality**: Secure logout with session termination
- **JWT Token System**: Secure token-based authentication with automatic refresh
- **Password Management**: Change password functionality with secure validation
- **Offline Login**: Login capability using cached credentials when offline
- **Session Management**: Automatic token refresh and secure session handling

### Data Management
- **Local Storage**: Room database for offline data persistence
- **Conflict Resolution**: Intelligent handling of concurrent edits and sync conflicts
- **Data Isolation**: User-specific data isolation and security
- **Sync Status Tracking**: Visual indicators for sync status and offline state

### User Interface
- **Material 3 Design**: Modern, responsive UI following Material Design guidelines
- **Jetpack Compose**: Declarative UI framework for efficient rendering
- **Responsive Layout**: Adaptive design for different screen sizes
- **Dark/Light Theme**: Support for system theme preferences
- **Intuitive Navigation**: Clean navigation flow between screens

## Technical Architecture

### Architecture Pattern
The application follows Clean Architecture principles with clear separation of concerns:

- **Presentation Layer**: Jetpack Compose UI with MVVM pattern
- **Domain Layer**: Business logic and data models
- **Data Layer**: Repository pattern with local and remote data sources

### Technology Stack

#### Core Technologies
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Repository Pattern
- **Database**: Room (SQLite)
- **Networking**: Retrofit 2.9.0 with OkHttp
- **Asynchronous Programming**: Kotlin Coroutines and Flow
- **Pagination**: Paging 3
- **Navigation**: Navigation Compose

#### Dependencies
- **AndroidX Core**: 1.16.0
- **Compose BOM**: 2024.09.00
- **Lifecycle**: 2.9.0
- **Room**: 2.6.1
- **Retrofit**: 2.9.0
- **Coroutines**: 1.7.3
- **Paging**: 3.3.6

### Project Structure

```
app/src/main/java/com/example/simplenote/
├── data/                           # Data Layer
│   ├── local/                      # Local Database
│   │   ├── dao/                    # Data Access Objects
│   │   ├── database/               # Room Database Configuration
│   │   ├── entity/                 # Database Entities
│   │   └── LocalNotePagingSource.kt
│   ├── remote/                     # Remote API Services
│   │   ├── ApiService.kt           # Authentication API
│   │   ├── AuthService.kt          # Auth-specific endpoints
│   │   ├── NoteApi.kt              # Note management API
│   │   ├── AuthInterceptor.kt      # JWT token interceptor
│   │   ├── TokenAuthenticator.kt   # Token refresh handling
│   │   └── RetrofitInstance.kt     # Retrofit configuration
│   ├── repository/                 # Repository Implementations
│   │   ├── AuthRepository.kt       # Authentication repository
│   │   ├── NoteRepository.kt       # Note management repository
│   │   ├── LocalNoteRepository.kt  # Local note operations
│   │   ├── LocalUserRepository.kt  # Local user operations
│   │   └── SettingsRepository.kt   # Settings management
│   └── sync/                       # Synchronization Management
│       └── SyncManager.kt          # Network state and sync handling
├── domain/                         # Domain Layer
│   └── model/                      # Data Models
│       ├── Note.kt                 # Note domain model
│       ├── LoginRequest.kt         # Authentication models
│       ├── RegisterRequest.kt      # Registration models
│       └── [Other domain models]
├── presentation/                   # Presentation Layer
│   ├── auth/                       # Authentication Screens
│   │   ├── AuthViewModel.kt        # Authentication logic
│   │   ├── ChangePasswordViewModel.kt
│   │   └── [Auth-related UI states]
│   ├── home/                       # Home Screen Logic
│   │   ├── HomeViewModel.kt        # Home screen logic
│   │   ├── AddNoteViewModel.kt     # Note creation logic
│   │   └── [Paging sources]
│   ├── settings/                   # Settings Screen
│   │   └── SettingsViewModel.kt    # Settings management
│   ├── ui/                         # UI Components
│   │   ├── HomeScreen.kt           # Main note list screen
│   │   ├── AddNoteScreen.kt        # Note creation screen
│   │   ├── NoteDetailScreen.kt     # Note editing screen
│   │   ├── LoginScreen.kt          # Authentication screens
│   │   ├── SettingsScreen.kt       # User settings
│   │   └── components/             # Reusable UI components
│   └── AppScreens.kt               # Navigation routes
├── ui/theme/                       # UI Theme Configuration
│   ├── Color.kt                    # Color definitions
│   ├── Theme.kt                    # Theme configuration
│   └── Type.kt                     # Typography definitions
└── utils/                          # Utility Classes
    └── TimeZoneUtils.kt            # Time zone utilities
```

## Getting Started

### Prerequisites

- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: Version 11 or later
- **Android SDK**: API level 26 (Android 8.0) or higher
- **Gradle**: 8.13.0 or later

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Simple-Note
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the Simple-Note directory and select it

3. **Sync the project**
   - Android Studio will automatically prompt to sync Gradle files
   - Click "Sync Now" or use the sync button in the toolbar

4. **Build the project**
   ```bash
   ./gradlew assembleDebug
   ```

5. **Run the application**
   - Connect an Android device or start an emulator
   - Click the "Run" button in Android Studio or use the command:
   ```bash
   ./gradlew installDebug
   ```

### Configuration

The application requires a backend API with the following endpoints:

#### Authentication Endpoints
- `POST /auth/login/` - User authentication
- `POST /auth/register/` - User registration
- `POST /auth/token/refresh/` - Token refresh
- `GET /auth/userinfo/` - User information retrieval
- `POST /auth/change-password/` - Password change

#### Note Management Endpoints
- `GET /notes/` - Retrieve notes with pagination
- `POST /api/notes/` - Create new note
- `GET /api/notes/{id}/` - Get specific note
- `PUT /api/notes/{id}/` - Update existing note
- `DELETE /api/notes/{id}/` - Delete note
- `GET /api/notes/filter/` - Search and filter notes

## Development

### Building the Project

#### Debug Build
```bash
./gradlew assembleDebug
```

#### Release Build
```bash
./gradlew assembleRelease
```

#### Running Tests
```bash
./gradlew test
./gradlew connectedAndroidTest
```

### Code Quality

The project follows Android development best practices:

- **Clean Architecture**: Clear separation of concerns across layers
- **MVVM Pattern**: Reactive UI with ViewModels and StateFlow
- **Repository Pattern**: Centralized data access with offline-first approach
- **Dependency Injection**: Manual DI with factory pattern for testability
- **Error Handling**: Comprehensive error handling with user-friendly messages
- **Security**: JWT token management with automatic refresh

### Database Schema

#### Notes Table
- `id`: Primary key (auto-generated)
- `title`: Note title
- `description`: Note content
- `created_at`: Creation timestamp
- `updated_at`: Last modification timestamp
- `creator_name`: Creator's display name
- `creator_username`: Creator's username
- `user_id`: Associated user ID
- `is_synced`: Sync status flag
- `is_modified`: Local modification flag
- `last_modified_local`: Local timestamp for conflict resolution
- `is_local_only`: Local-only creation flag

#### Users Table
- `id`: Primary key
- `username`: Unique username
- `email`: User email address
- `first_name`: User's first name
- `last_name`: User's last name
- `is_current_user`: Current user flag

## Offline Support

The application provides comprehensive offline-first functionality:

### Local Database (Room)
- **Room Database**: SQLite-based local storage for all user data and notes
- **Entity Management**: Complete note and user entity management with sync status tracking
- **Automatic Caching**: Server data is automatically cached locally for offline access
- **Conflict Resolution**: Intelligent handling of data conflicts during synchronization
- **Data Persistence**: All user notes and data persist locally without internet connectivity

### Offline-First Operations
- **Note Creation**: Create notes offline with automatic sync when online
- **Note Editing**: Edit notes offline with conflict resolution during sync
- **Note Deletion**: Delete notes offline with server sync when connectivity restored
- **Search Functionality**: Full search capabilities work offline using local database
- **User Authentication**: Login using cached credentials when offline
- **Profile Management**: View and manage profile information offline

### Synchronization
- **Background Sync**: Automatic synchronization when network connectivity is restored
- **Manual Refresh**: User-initiated data refresh and sync operations
- **Sync Status Tracking**: Visual indicators for sync state and offline mode
- **Incremental Sync**: Only sync changed data to optimize performance and bandwidth
- **Sync Manager**: Dedicated SyncManager for handling network state and sync operations

### Network Management
- **Connectivity Monitoring**: Real-time network state detection using ConnectivityManager
- **Graceful Degradation**: Full functionality without network connectivity
- **Retry Logic**: Automatic retry for failed network operations
- **Offline Indicators**: UI components showing current connectivity and sync status

## Security

### Authentication Security
- **JWT Tokens**: Secure token-based authentication with access and refresh tokens
- **Token Refresh Mechanism**: Automatic token refresh using refresh tokens before expiration
- **Token Authenticator**: Built-in TokenAuthenticator for handling token refresh requests
- **Secure Storage**: Encrypted storage of sensitive data using SharedPreferences
- **Session Management**: Proper session lifecycle management with automatic logout
- **Offline Token Caching**: Cached tokens for offline authentication capability

### Data Security
- **User Isolation**: Complete data isolation between users
- **Input Validation**: Comprehensive input validation and sanitization
- **Secure Communication**: HTTPS-only API communication
- **Local Encryption**: Sensitive data encryption in local storage

## Performance

### Optimization Features
- **Pagination**: Efficient loading of large datasets
- **Caching**: Intelligent data caching for improved performance
- **Background Processing**: Non-blocking UI with coroutines
- **Memory Management**: Efficient memory usage with proper lifecycle management
- **Database Optimization**: Indexed queries and efficient data access

### Monitoring
- **Sync Status**: Real-time sync status monitoring
- **Error Tracking**: Comprehensive error logging and handling
- **Performance Metrics**: Built-in performance monitoring

## Troubleshooting

### Common Issues

#### Build Issues
- **Gradle Sync Failures**: Ensure JDK 11+ is installed and configured
- **Dependency Conflicts**: Clean and rebuild the project
- **SDK Issues**: Verify Android SDK installation and API levels

#### Runtime Issues
- **Network Errors**: Check internet connectivity and API endpoint configuration
- **Database Errors**: Clear app data and restart the application
- **Sync Issues**: Force refresh or restart the sync process

#### Development Issues
- **Code Compilation**: Ensure all dependencies are properly imported
- **UI Rendering**: Check Compose version compatibility
- **Navigation Issues**: Verify navigation routes and parameters

### Debug Information
- Enable debug logging in the application
- Check network connectivity status
- Monitor sync status in the settings screen
- Review error logs in Android Studio

## Version Information

- **Application Version**: 1.0
- **Version Code**: 1
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 35

## License

This project is licensed under the MIT License. See the LICENSE file for details.