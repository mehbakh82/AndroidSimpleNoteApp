# Page 1

9/10/25, 4:59 PMSimpleNote
Page 1 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
SimpleNote/api/schema/Simple Note Project APIs
Authorizeauth
POSTPOST/api/auth/change-password/Change User PasswordAllows an authenticated user to change their own password.
Try it outNo parametersRequest body
application/jsonSchema 0.1.0 OAS 3.0
ParametersrequiredExample Value{{{{        "old_password""old_password""old_password""old_password": : : : "string""string""string""string",,,,        "new_password""new_password""new_password""new_password": : : : "string""string""string""string"}}}}

---

# Page 2

9/10/25, 4:59 PMSimpleNote
Page 2 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo linksExample Value{{{{        "detail""detail""detail""detail": : : : "string""string""string""string"}}}}
Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }

---

# Page 3

9/10/25, 4:59 PMSimpleNote
Page 3 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {

---

# Page 4

9/10/25, 4:59 PMSimpleNote
Page 4 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
500Media type
application/jsonExamples
APIExceptionSchemaNo links
POSTPOST/api/auth/register/
Try it outNo parametersRequest body
application/jsonSchema                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}ParametersrequiredExample Value{{{{        "username""username""username""username": : : : "VMAJ_aiM3sbfPzTfvuao7yvzSrVfGzLT9+bKXfV.zVk0wzS3Q_DgMU2gUPeH7Nunr-c_7"VMAJ_aiM3sbfPzTfvuao7yvzSrVfGzLT9+bKXfV.zVk0wzS3Q_DgMU2gUPeH7Nunr-c_7"VMAJ_aiM3sbfPzTfvuao7yvzSrVfGzLT9+bKXfV.zVk0wzS3Q_DgMU2gUPeH7Nunr-c_7"VMAJ_aiM3sbfPzTfvuao7yvzSrVfGzLT9+bKXfV.zVk0wzS3Q_DgMU2gUPeH7Nunr-c_7h+l0wA-un3IyNrrn4f"h+l0wA-un3IyNrrn4f"h+l0wA-un3IyNrrn4f"h+l0wA-un3IyNrrn4f",,,,        "password""password""password""password": : : : "string""string""string""string",,,,        "email""email""email""email": : : : "user@example.com""user@example.com""user@example.com""user@example.com",,,,        "first_name""first_name""first_name""first_name": : : : "string""string""string""string",,,,        "last_name""last_name""last_name""last_name": : : : "string""string""string""string"}}}}

---

# Page 5

9/10/25, 4:59 PMSimpleNote
Page 5 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
ResponsesCodeDescriptionLinks201Media type
application/jsonControls Accept header.SchemaNo links
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo linksExample Value{{{{        "username""username""username""username": : : : "FPf0ljBDAiWsKO0+B.04w@9EJ0hn61cX6hy1gO2X1K2pL6"FPf0ljBDAiWsKO0+B.04w@9EJ0hn61cX6hy1gO2X1K2pL6"FPf0ljBDAiWsKO0+B.04w@9EJ0hn61cX6hy1gO2X1K2pL6"FPf0ljBDAiWsKO0+B.04w@9EJ0hn61cX6hy1gO2X1K2pL6P@y5RqhoDA8aLbYjbHtmRP3ZesJKey7J"P@y5RqhoDA8aLbYjbHtmRP3ZesJKey7J"P@y5RqhoDA8aLbYjbHtmRP3ZesJKey7J"P@y5RqhoDA8aLbYjbHtmRP3ZesJKey7J",,,,        "email""email""email""email": : : : "user@example.com""user@example.com""user@example.com""user@example.com",,,,        "first_name""first_name""first_name""first_name": : : : "string""string""string""string",,,,        "last_name""last_name""last_name""last_name": : : : "string""string""string""string"}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [

---

# Page 6

9/10/25, 4:59 PMSimpleNote
Page 6 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo links    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value

---

# Page 7

9/10/25, 4:59 PMSimpleNote
Page 7 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo links{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 8

9/10/25, 4:59 PMSimpleNote
Page 8 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
POSTPOST/api/auth/token/Takes a set of user credentials and returns an access and refresh JSON web token pair to prove theauthentication of those credentials.
Try it outNo parametersRequest body
application/jsonSchema
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links
400No linksParametersrequiredExample Value{{{{        "username""username""username""username": : : : "string""string""string""string",,,,        "password""password""password""password": : : : "string""string""string""string"}}}}
Example Value{{{{        "access""access""access""access": : : : "string""string""string""string",,,,        "refresh""refresh""refresh""refresh": : : : "string""string""string""string"}}}}

---

# Page 9

9/10/25, 4:59 PMSimpleNote
Page 9 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Media type
application/jsonSchema
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo linksExample Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 10

9/10/25, 4:59 PMSimpleNote
Page 10 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [

---

# Page 11

9/10/25, 4:59 PMSimpleNote
Page 11 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
POSTPOST/api/auth/token/refresh/Takes a refresh type JSON web token and returns an access type JSON web token if the refresh tokenis valid.
Try it outNo parametersRequest body
application/jsonSchema
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
ParametersrequiredExample Value{{{{        "refresh""refresh""refresh""refresh": : : : "string""string""string""string"}}}}
Example Value

---

# Page 12

9/10/25, 4:59 PMSimpleNote
Page 12 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links{{{{        "access""access""access""access": : : : "string""string""string""string"}}}}
Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,

---

# Page 13

9/10/25, 4:59 PMSimpleNote
Page 13 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo links                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value

---

# Page 14

9/10/25, 4:59 PMSimpleNote
Page 14 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
GETGET/api/auth/userinfo/
Try it outNo parametersResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links
400Media type
application/jsonSchemaNo links{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Parameters
Example Value{{{{        "id""id""id""id": : : : 0000,,,,        "username""username""username""username": : : : "M@dDq16wuoxrWZyB7UzE65mA54EG53LETrQh-tc+kcV_4""M@dDq16wuoxrWZyB7UzE65mA54EG53LETrQh-tc+kcV_4""M@dDq16wuoxrWZyB7UzE65mA54EG53LETrQh-tc+kcV_4""M@dDq16wuoxrWZyB7UzE65mA54EG53LETrQh-tc+kcV_4",,,,        "email""email""email""email": : : : "user@example.com""user@example.com""user@example.com""user@example.com",,,,        "first_name""first_name""first_name""first_name": : : : "string""string""string""string",,,,        "last_name""last_name""last_name""last_name": : : : "string""string""string""string"}}}}Example Value

---

# Page 15

9/10/25, 4:59 PMSimpleNote
Page 15 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableNo links{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "parse_error""parse_error""parse_error""parse_error",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string",,,,                        "attr""attr""attr""attr": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 16

9/10/25, 4:59 PMSimpleNote
Page 16 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Schema
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 17

9/10/25, 4:59 PMSimpleNote
Page 17 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrievenotes
GETGET/api/notes/API view for listing and creating a single note
Try it outNameDescriptionpageinteger(query)A page number within the paginated result set.pagepage_sizeinteger(query)Number of results to return per page.page_sizeResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links
Parameters
Example Value{{{{        "count""count""count""count": : : : 123123123123,,,,

---

# Page 18

9/10/25, 4:59 PMSimpleNote
Page 18 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
404No links        "next""next""next""next": : : : "http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4",,,,        "previous""previous""previous""previous": : : : "http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2",,,,        "results""results""results""results": [: [: [: [    {    {    {    {                        "id""id""id""id": : : : 0000,,,,                        "title""title""title""title": : : : "string""string""string""string",,,,                        "description""description""description""description": : : : "string""string""string""string",,,,                        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z",,,,                        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z""2025-09-10T13:58:04.906Z",,,,                        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,                        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "parse_error""parse_error""parse_error""parse_error",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string",,,,                        "attr""attr""attr""attr": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 19

9/10/25, 4:59 PMSimpleNote
Page 19 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Media type
application/jsonExamples
NotFoundSchema
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull

---

# Page 20

9/10/25, 4:59 PMSimpleNote
Page 20 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo links
POSTPOST/api/notes/API view for listing and creating a single note    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}


---

# Page 21

9/10/25, 4:59 PMSimpleNote
Page 21 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Try it outNo parametersRequest body
application/jsonSchema
ResponsesCodeDescriptionLinks201Media type
application/jsonControls Accept header.SchemaNo links
400Media type
application/jsonSchemaNo linksParametersrequiredExample Value{{{{        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string"}}}}
Example Value{{{{        "id""id""id""id": : : : 0000,,,,        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string",,,,        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z",,,,        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z""2025-09-10T13:58:04.921Z",,,,        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"}}}}Example Value

---

# Page 22

9/10/25, 4:59 PMSimpleNote
Page 22 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedNo links{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 23

9/10/25, 4:59 PMSimpleNote
Page 23 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Schema
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500No linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 24

9/10/25, 4:59 PMSimpleNote
Page 24 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Media type
application/jsonExamples
APIExceptionSchema
GETGET/api/notes/{id}/
Try it outNameDescriptionid *integer(path)idResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo linksExample Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Parameters
required
Example Value

---

# Page 25

9/10/25, 4:59 PMSimpleNote
Page 25 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
403Media type
application/jsonExamples
PermissionDeniedSchemaNo links{{{{        "id""id""id""id": : : : 0000,,,,        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string",,,,        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z",,,,        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z""2025-09-10T13:58:04.933Z",,,,        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "parse_error""parse_error""parse_error""parse_error",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string",,,,                        "attr""attr""attr""attr": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value

---

# Page 26

9/10/25, 4:59 PMSimpleNote
Page 26 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406No links{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "permission_denied""permission_denied""permission_denied""permission_denied",,,,                        "detail""detail""detail""detail": : : : "You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this action."tion."tion."tion.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 27

9/10/25, 4:59 PMSimpleNote
Page 27 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Media type
application/jsonExamples
NotAcceptableSchema
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,

---

# Page 28

9/10/25, 4:59 PMSimpleNote
Page 28 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
PUTPUT/api/notes/{id}/
Try it outNameDescriptionid *integer(path)idRequest body
application/jsonSchema
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Parameters
required
requiredExample Value{{{{        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string"}}}}
Example Value{{{{

---

# Page 29

9/10/25, 4:59 PMSimpleNote
Page 29 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
403Media type
application/jsonExamples
PermissionDeniedSchemaNo links        "id""id""id""id": : : : 0000,,,,        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string",,,,        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z",,,,        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z""2025-09-10T13:58:04.950Z",,,,        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{

---

# Page 30

9/10/25, 4:59 PMSimpleNote
Page 30 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableNo links        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "permission_denied""permission_denied""permission_denied""permission_denied",,,,                        "detail""detail""detail""detail": : : : "You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this action."tion."tion."tion.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 31

9/10/25, 4:59 PMSimpleNote
Page 31 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Schema
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 32

9/10/25, 4:59 PMSimpleNote
Page 32 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
PATCHPATCH/api/notes/{id}/
Try it outNameDescriptionid *integer(path)idRequest body
application/jsonSchema
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo links
Parameters
required
Example Value{{{{        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string"}}}}
Example Value{{{{        "id""id""id""id": : : : 0000,,,,        "title""title""title""title": : : : "string""string""string""string",,,,        "description""description""description""description": : : : "string""string""string""string",,,,        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z",,,,        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z""2025-09-10T13:58:04.970Z",,,,        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,

---

# Page 33

9/10/25, 4:59 PMSimpleNote
Page 33 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
403Media type
application/jsonExamples
PermissionDeniedSchemaNo links        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "permission_denied""permission_denied""permission_denied""permission_denied",,,,                        "detail""detail""detail""detail": : : : "You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this action."tion."tion."tion.",,,,

---

# Page 34

9/10/25, 4:59 PMSimpleNote
Page 34 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo links                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [

---

# Page 35

9/10/25, 4:59 PMSimpleNote
Page 35 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/jsonExamples
APIExceptionSchemaNo links
DELETEDELETE/api/notes/{id}/    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}


---

# Page 36

9/10/25, 4:59 PMSimpleNote
Page 36 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Try it outNameDescriptionid *integer(path)idResponsesCodeDescriptionLinks204No response bodyNo links400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo linksParameters
required
Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "parse_error""parse_error""parse_error""parse_error",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string",,,,                        "attr""attr""attr""attr": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {

---

# Page 37

9/10/25, 4:59 PMSimpleNote
Page 37 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
403Media type
application/jsonExamples
PermissionDeniedSchemaNo links
404Media type
application/jsonExamples
NotFoundSchemaNo links
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "permission_denied""permission_denied""permission_denied""permission_denied",,,,                        "detail""detail""detail""detail": : : : "You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this ac"You do not have permission to perform this action."tion."tion."tion.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value

---

# Page 38

9/10/25, 4:59 PMSimpleNote
Page 38 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links
500No links{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 39

9/10/25, 4:59 PMSimpleNote
Page 39 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Media type
application/jsonExamples
APIExceptionSchema
POSTPOST/api/notes/bulkAPI view for batch creation of multiple notes at once
Try it outNo parametersRequest body
application/jsonSchemaExample Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
ParametersrequiredExample Value[[[[  {  {  {  {                "title""title""title""title": : : : "string""string""string""string",,,,                "description""description""description""description": : : : "string""string""string""string"  }  }  }  }]]]]

---

# Page 40

9/10/25, 4:59 PMSimpleNote
Page 40 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
ResponsesCodeDescriptionLinks201Media type
application/jsonControls Accept header.SchemaNo links
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo linksExample Value[[[[  {  {  {  {                "id""id""id""id": : : : 0000,,,,                "title""title""title""title": : : : "string""string""string""string",,,,                "description""description""description""description": : : : "string""string""string""string",,,,                "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z",,,,                "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z""2025-09-10T13:58:05.002Z",,,,                "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,                "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"  }  }  }  }]]]]Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "non_field_errors""non_field_errors""non_field_errors""non_field_errors",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{

---

# Page 41

9/10/25, 4:59 PMSimpleNote
Page 41 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeNo links        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 42

9/10/25, 4:59 PMSimpleNote
Page 42 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
Schema
500Media type
application/jsonExamples
APIExceptionSchemaNo links
GETGET/api/notes/filter
Try it outNameDescriptiondescriptionstring(query)descriptionpageinteger(query)A page number within the paginated result set.pageExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Parameters

---

# Page 43

9/10/25, 4:59 PMSimpleNote
Page 43 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
page_sizeinteger(query)Number of results to return per page.page_sizetitlestring(query)titleupdated__gtestring($date-time)(query)updated__gteupdated__ltestring($date-time)(query)updated__lte
ResponsesCodeDescriptionLinks200Media type
application/jsonControls Accept header.SchemaNo linksExample Value{{{{        "count""count""count""count": : : : 123123123123,,,,        "next""next""next""next": : : : "http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4""http://api.example.org/accounts/?page=4",,,,        "previous""previous""previous""previous": : : : "http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2""http://api.example.org/accounts/?page=2",,,,        "results""results""results""results": [: [: [: [    {    {    {    {                        "id""id""id""id": : : : 0000,,,,                        "title""title""title""title": : : : "string""string""string""string",,,,                        "description""description""description""description": : : : "string""string""string""string",,,,                        "created_at""created_at""created_at""created_at": : : : "2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z",,,,                        "updated_at""updated_at""updated_at""updated_at": : : : "2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z""2025-09-10T13:58:05.021Z",,,,                        "creator_name""creator_name""creator_name""creator_name": : : : "string""string""string""string",,,,                        "creator_username""creator_username""creator_username""creator_username": : : : "string""string""string""string"    }    }    }    }

---

# Page 44

9/10/25, 4:59 PMSimpleNote
Page 44 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
400Media type
application/jsonSchemaNo links
401Media type
application/jsonExamples
AuthenticationFailedSchemaNo links
404Media type
application/jsonExamples
NotFoundSchemaNo links  ]  ]  ]  ]}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "attr""attr""attr""attr": : : : "title""title""title""title",,,,                        "code""code""code""code": : : : "string""string""string""string",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_found""not_found""not_found""not_found",,,,                        "detail""detail""detail""detail": : : : "Not found.""Not found.""Not found.""Not found.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull

---

# Page 45

9/10/25, 4:59 PMSimpleNote
Page 45 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
405Media type
application/jsonExamples
MethodNotAllowedSchemaNo links
406Media type
application/jsonExamples
NotAcceptableSchemaNo links
415Media type
application/jsonExamples
UnsupportedMediaTypeSchemaNo links    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept heade"Could not satisfy the request Accept header."r."r."r.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [

---

# Page 46

9/10/25, 4:59 PMSimpleNote
Page 46 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
500Media type
application/jsonExamples
APIExceptionSchemaNo links
schema
GETGET/api/schema/OpenApi3 schema for this API. Format can be selected via content negotiation.YAML: application/vnd.oai.openapiJSON: application/vnd.oai.openapi+json
Try it outNameDescriptionformatstringAvailable values : json, yaml    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" i"Unsupported media type \"application/json\" in request."n request."n request."n request.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Parameters

---

# Page 47

9/10/25, 4:59 PMSimpleNote
Page 47 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
(query)
--langstring(query)Available values : af, ar, ar-dz, ast, az, be, bg, bn, br, bs, ca, ckb, cs, cy, da,de, dsb, el, en, en-au, en-gb, eo, es, es-ar, es-co, es-mx, es-ni, es-ve, et, eu,fa, ﬁ, fr, fy, ga, gd, gl, he, hi, hr, hsb, hu, hy, ia, id, ig, io, is, it, ja, ka, kab, kk,km, kn, ko, ky, lb, lt, lv, mk, ml, mn, mr, ms, my, nb, ne, nl, nn, os, pa, pl, pt, pt-br, ro, ru, sk, sl, sq, sr, sr-latn, sv, sw, ta, te, tg, th, tk, tr, tt, udm, uk, ur, uz, vi,zh-hans, zh-hant
--ResponsesCodeDescriptionLinks200Media type
application/vnd.oai.openapiControls Accept header.SchemaNo links
400Media type
application/vnd.oai.openapiSchemaNo linksExample Value{{{{        "additionalProp1""additionalProp1""additionalProp1""additionalProp1": : : : "string""string""string""string",,,,        "additionalProp2""additionalProp2""additionalProp2""additionalProp2": : : : "string""string""string""string",,,,        "additionalProp3""additionalProp3""additionalProp3""additionalProp3": : : : "string""string""string""string"}}}}Example Value{{{{        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "parse_error""parse_error""parse_error""parse_error",,,,                        "detail""detail""detail""detail": : : : "string""string""string""string",,,,                        "attr""attr""attr""attr": : : : "string""string""string""string"    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 48

9/10/25, 4:59 PMSimpleNote
Page 48 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
401Media type
application/vnd.oai.openapiExamples
AuthenticationFailedSchemaNo links
405Media type
application/vnd.oai.openapiExamples
MethodNotAllowedSchemaNo links
406Media type
application/vnd.oai.openapiExamples
NotAcceptableSchemaNo linksExample Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "authentication_failed""authentication_failed""authentication_failed""authentication_failed",,,,                        "detail""detail""detail""detail": : : : "Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.""Incorrect authentication credentials.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "method_not_allowed""method_not_allowed""method_not_allowed""method_not_allowed",,,,                        "detail""detail""detail""detail": : : : "Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.""Method \"get\" not allowed.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "not_acceptable""not_acceptable""not_acceptable""not_acceptable",,,,                        "detail""detail""detail""detail": : : : "Could not satisfy the request Accept header.""Could not satisfy the request Accept header.""Could not satisfy the request Accept header.""Could not satisfy the request Accept header.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }

---

# Page 49

9/10/25, 4:59 PMSimpleNote
Page 49 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve
415Media type
application/vnd.oai.openapiExamples
UnsupportedMediaTypeSchemaNo links
500Media type
application/vnd.oai.openapiExamples
APIExceptionSchemaNo links
Schemas  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "client_error""client_error""client_error""client_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "unsupported_media_type""unsupported_media_type""unsupported_media_type""unsupported_media_type",,,,                        "detail""detail""detail""detail": : : : "Unsupported media type \"application/json\" in req"Unsupported media type \"application/json\" in req"Unsupported media type \"application/json\" in req"Unsupported media type \"application/json\" in request."uest."uest."uest.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}
Example Value{{{{        "type""type""type""type": : : : "server_error""server_error""server_error""server_error",,,,        "errors""errors""errors""errors": [: [: [: [    {    {    {    {                        "code""code""code""code": : : : "error""error""error""error",,,,                        "detail""detail""detail""detail": : : : "A server error occurred.""A server error occurred.""A server error occurred.""A server error occurred.",,,,                        "attr""attr""attr""attr": : : : nullnullnullnull    }    }    }    }  ]  ]  ]  ]}}}}

---

# Page 50

9/10/25, 4:59 PMSimpleNote
Page 50 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrievestringnon_field_errors - non_field_errorstitle - titledescription - descriptionEnum:Array [ 3 ]Attr750Enum
{oneOf ->{...}{...}}AuthChangePasswordCreateErrorResponse400AuthChangePasswordCreateValidationErrorParseErrorResponse{type*[...]errors*[...]}AuthChangePasswordCreateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}AuthChangePasswordCreateValidationItemErrorAuthChangePasswordCreateValidationItemErrorAttrEnum
stringnon_field_errors - non_field_errorsold_password - old_passwordnew_password - new_passwordEnum:Array [ 3 ]AuthChangePasswordCreateValidationItemErrorAttrEnum

---

# Page 51

9/10/25, 4:59 PMSimpleNote
Page 51 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{oneOf ->{...}{...}}AuthRegisterCreateErrorResponse400AuthRegisterCreateValidationErrorParseErrorResponse{type*[...]errors*[...]}AuthRegisterCreateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}AuthRegisterCreateValidationItemErrorAuthRegisterCreateValidationItemErrorAttrEnum
stringnon_field_errors - non_field_errorsusername - usernamepassword - passwordemail - emailfirst_name - first_namelast_name - last_nameEnum:Array [ 6 ]AuthRegisterCreateValidationItemErrorAttrEnum
{oneOf ->{...}{...}}AuthTokenCreateErrorResponse400AuthTokenCreateValidationErrorParseErrorResponse

---

# Page 52

9/10/25, 4:59 PMSimpleNote
Page 52 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{type*[...]errors*[...]}AuthTokenCreateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}AuthTokenCreateValidationItemErrorAuthTokenCreateValidationItemErrorAttrEnum
stringnon_field_errors - non_field_errorsusername - usernamepassword - passwordEnum:Array [ 3 ]AuthTokenCreateValidationItemErrorAttrEnum
{oneOf ->{...}{...}}AuthTokenRefreshCreateErrorResponse400AuthTokenRefreshCreateValidationErrorParseErrorResponse{type*[...]errors*[...]}AuthTokenRefreshCreateValidationErrorValidationErrorEnum

---

# Page 53

9/10/25, 4:59 PMSimpleNote
Page 53 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{attr*[...]code*[...]detail*[...]}AuthTokenRefreshCreateValidationItemErrorAuthTokenRefreshCreateValidationItemErrorAttrEnum
stringnon_field_errors - non_field_errorsrefresh - refreshEnum:Array [ 2 ]AuthTokenRefreshCreateValidationItemErrorAttrEnum
{oneOf ->{...}}AuthUserinfoRetrieveErrorResponse400ParseErrorResponse{old_password*[...]new_password*[...]}ChangePasswordRequest
stringclient_error - Client ErrorEnum:Array [ 1 ]ClientErrorEnum

---

# Page 54

9/10/25, 4:59 PMSimpleNote
Page 54 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{code*[...]detail*[...]attr*[...]}Error401
{code*[...]detail*[...]attr*[...]}Error403ErrorCode403Enum
{code*[...]detail*[...]attr*[...]}Error404ErrorCode404Enum
{code*[...]detail*[...]attr*[...]}Error405ErrorCode405Enum
{code*[...]detail*[...]attr*[...]}Error406ErrorCode406Enum

---

# Page 55

9/10/25, 4:59 PMSimpleNote
Page 55 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{code*[...]detail*[...]attr*[...]}Error415ErrorCode415Enum
{code*[...]detail*[...]attr*[...]}Error500ErrorCode500Enum
stringpermission_denied - Permission DeniedEnum:Array [ 1 ]ErrorCode403Enum
stringnot_found - Not FoundEnum:Array [ 1 ]ErrorCode404Enum
stringmethod_not_allowed - Method Not AllowedEnum:Array [ 1 ]ErrorCode405Enum

---

# Page 56

9/10/25, 4:59 PMSimpleNote
Page 56 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrievestringnot_acceptable - Not AcceptableEnum:Array [ 1 ]ErrorCode406Enum
stringunsupported_media_type - Unsupported Media TypeEnum:Array [ 1 ]ErrorCode415Enum
stringerror - ErrorEnum:Array [ 1 ]ErrorCode500Enum
{type*[...]errors*[...]}ErrorResponse401ClientErrorEnum
{type*[...]errors*[...]}ErrorResponse403ClientErrorEnum

---

# Page 57

9/10/25, 4:59 PMSimpleNote
Page 57 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{type*[...]errors*[...]}ErrorResponse404ClientErrorEnum
{type*[...]errors*[...]}ErrorResponse405ClientErrorEnum
{type*[...]errors*[...]}ErrorResponse406ClientErrorEnum
{type*[...]errors*[...]}ErrorResponse415ClientErrorEnum
{type*[...]errors*[...]}ErrorResponse500ServerErrorEnum
{detail*[...]}Message

---

# Page 58

9/10/25, 4:59 PMSimpleNote
Page 58 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{id*[...]title*[...]description*[...]created_at*[...]updated_at*[...]creator_name*[...]creator_username*[...]}Note
{title*[...]description*[...]}NoteRequest
{oneOf ->{...}{...}}NotesBulkCreateErrorResponse400NotesBulkCreateValidationErrorParseErrorResponse{type*[...]errors*[...]}NotesBulkCreateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}NotesBulkCreateValidationItemErrorNotesBulkCreateValidationItemErrorAttrEnum

---

# Page 59

9/10/25, 4:59 PMSimpleNote
Page 59 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrievestringnon_field_errors - non_field_errorsINDEX.non_field_errors - INDEX.non_field_errorsINDEX.title - INDEX.titleINDEX.description - INDEX.descriptionEnum:Array [ 4 ]NotesBulkCreateValidationItemErrorAttrEnum
{oneOf ->{...}{...}}NotesCreateErrorResponse400NotesCreateValidationErrorParseErrorResponse{type*[...]errors*[...]}NotesCreateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}NotesCreateValidationItemErrorAttr750Enum
{oneOf ->{...}}NotesDestroyErrorResponse400ParseErrorResponse

---

# Page 60

9/10/25, 4:59 PMSimpleNote
Page 60 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{oneOf ->{...}{...}}NotesFilterListErrorResponse400NotesFilterListValidationErrorParseErrorResponseNotesFilterListValidationError{attr*[...]code*[...]detail*[...]}NotesFilterListValidationItemErrorNotesFilterListValidationItemErrorAttrEnum
stringtitle - titledescription - descriptionupdated__lte - updated__lteupdated__gte - updated__gteEnum:Array [ 4 ]NotesFilterListValidationItemErrorAttrEnum
{oneOf ->{...}}NotesListErrorResponse400ParseErrorResponse{oneOf ->{...}{...}}NotesPartialUpdateErrorResponse400NotesPartialUpdateValidationErrorParseErrorResponse

---

# Page 61

9/10/25, 4:59 PMSimpleNote
Page 61 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{type*[...]errors*[...]}NotesPartialUpdateValidationErrorValidationErrorEnum
{attr*[...]code*[...]detail*[...]}NotesPartialUpdateValidationItemErrorAttr750Enum
{oneOf ->{...}}NotesRetrieveErrorResponse400ParseErrorResponse{oneOf ->{...}{...}}NotesUpdateErrorResponse400NotesUpdateValidationErrorParseErrorResponse{type*[...]errors*[...]}NotesUpdateValidationErrorValidationErrorEnum

---

# Page 62

9/10/25, 4:59 PMSimpleNote
Page 62 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{attr*[...]code*[...]detail*[...]}NotesUpdateValidationItemErrorAttr750Enum
{count*[...]next[...]previous[...]results*[...]}PaginatedNoteList
{code*[...]detail*[...]attr*[...]}ParseErrorParseErrorCodeEnum
stringparse_error - Parse ErrorEnum:Array [ 1 ]ParseErrorCodeEnum
{type*[...]errors*[...]}ParseErrorResponseClientErrorEnum

---

# Page 63

9/10/25, 4:59 PMSimpleNote
Page 63 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{title[...]description[...]}PatchedNoteRequest
{username*[...]email*[...]first_name[...]last_name[...]}Register
{username*[...]password*[...]email*[...]first_name[...]last_name[...]}RegisterRequest
{oneOf ->{...}}SchemaRetrieveErrorResponse400ParseErrorResponsestringserver_error - Server ErrorEnum:Array [ 1 ]ServerErrorEnum

---

# Page 64

9/10/25, 4:59 PMSimpleNote
Page 64 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrieve{access*[...]refresh*[...]}TokenObtainPair
{username*[...]password*[...]}TokenObtainPairRequest
{access*[...]}TokenRefresh
{refresh*[...]}TokenRefreshRequest
{id*[...]username*[...]email*[...]first_name[...]last_name[...]}UserInfo

---

# Page 65

9/10/25, 4:59 PMSimpleNote
Page 65 of 65http://localhost:8000/api/schema/swagger-ui/#/schema/schema_retrievestringvalidation_error - Validation ErrorEnum:Array [ 1 ]ValidationErrorEnum

---

