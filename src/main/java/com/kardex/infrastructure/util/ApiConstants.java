package com.kardex.infrastructure.util;

public class ApiConstants {

    public static final class EMAIL{
        public static String CONTENT(String token){
            String resetLink = "http://127.0.0.1:5501/View/cambioContrasena.html?token=" + token;

            return "<div style='max-width: 600px; margin: auto; font-family: Arial, sans-serif; background: #ffffff; border-radius: 10px; overflow: hidden; box-shadow: 0px 4px 10px rgba(0,0,0,0.1);'>" +
                    "<div style='background: linear-gradient(135deg, #007bff, #00aaff); padding: 20px; text-align: center; color: white;'>" +
                    "    <h1 style='margin: 0;'>🔐 Recuperación de contraseña</h1>" +
                    "</div>" +
                    "<div style='padding: 20px; text-align: center;'>" +
                    "    <p style='font-size: 18px; color: #333;'>Hola,</p>" +
                    "    <p style='font-size: 16px; color: #555;'>Hemos recibido una solicitud para restablecer tu contraseña.</p>" +
                    "    <p style='font-size: 16px; color: #555;'>Si no realizaste esta solicitud, ignora este mensaje. De lo contrario, haz clic en el siguiente botón para restablecer tu contraseña:</p>" +
                    "    <a href='" + resetLink + "' style='display: inline-block; padding: 12px 25px; font-size: 18px; background: #007bff; color: white; text-decoration: none; border-radius: 8px; font-weight: bold; transition: background 0.3s;'>🔑 Restablecer contraseña</a>" +
                    "    <p style='margin-top: 20px; font-size: 14px; color: #777;'>Este enlace expirará en 30 minutos por razones de seguridad.</p>" +
                    "</div>" +
                    "<div style='background: #f4f4f4; padding: 10px; text-align: center; font-size: 14px; color: #888;'>" +
                    "    <p>Si necesitas ayuda, contáctanos. 📩</p>" +
                    "</div>" +
                    "</div>";
        }
        ;

    } ;

    public static final class AZURE{
        public static final String AZURE_CONNECTION = "${azure.storage.connection-string}";
        public static final String AZURE_USERS_CONTAINER_NAME = "${azure.storage.products-container-name}";
        public static final String FILE_NAME_SEPARATOR = "_";
    }


    public static final class PATHS{
        public static final String USERS = "/users";
        public static final String USERS_CREATE = "/create";
        public static final String USER_GET = "/me";
        public static final String USER_IMAGE_PATH = "/update/image";
        public static final String PASSWORD = "/password";
        public static final String PASSWORD_REQUEST = "/request-reset";
        public static final String PASSWORD_RESET = "/reset";
        public static final String AUTH_USER = "/auth";
        public static final String AUTH_LOGIN = "/login";
        public static final String GOOGLE_LOGIN = "/google";

    }

    public static final class Responses {
        public static final String RESPONSE_200_DESCRIPTION = "User logged in successfully";
        public static final String RESPONSE_200_GET_DESCRIPTION = "User returned successfully";
        public static final String RESPONSE_200_UPDATE_DESCRIPTION = "User updated successfully";
        public static final String RESPONSE_201_DESCRIPTION = "User account successfully created";
        public static final String RESPONSE_400_DESCRIPTION = "Invalid request body for user account creation";
        public static final String RESPONSE_404_DESCRIPTION = "User not found";
        public static final String RESPONSE_401_DESCRIPTION = "Incorrect username or password";
        public static final String RESPONSE_400 = "400";
        public static final String RESPONSE_401 = "401";
        public static final String RESPONSE_201 = "201";
        public static final String RESPONSE_200 = "200";
        public static final String RESPONSE_404 = "404";
    }

    public static final class OPERATIONS {
        public static final String OPERATION_NEW_USER = "Add new user";
        public static final String OPERATION_UPDATE_USER = "Update user";
        public static final String OPERATION_PATCH_IMAGE_USER = "Update only user image";
        public static final String OPERATION_USER_RETURNED = "user returned";
    }

    public static final class CORS {
        public static final String ALLOWED_PATHS = "/**";
        public static final String[] ALLOWED_ORIGINS = { "http://127.0.0.1:5501", "http://localhost:3000" };
        public static final String[] ALLOWED_METHODS = { "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS" };
    }
    
    public static final String CLIENT_ID = "58628413236-evps3br9c44204kst8in7mm165o84s3l.apps.googleusercontent.com";

    private ApiConstants() {

        // Constructor privado para evitar la instanciación
    }
}
