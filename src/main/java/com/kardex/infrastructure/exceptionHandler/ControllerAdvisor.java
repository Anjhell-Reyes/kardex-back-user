package com.kardex.infrastructure.exceptionHandler;

import com.kardex.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    //required field errors
    @ExceptionHandler(NameNotNullException.class)
    public ResponseEntity<Map<String, String>> handleNameNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NAME_NULL.getMessage()));
    }

    @ExceptionHandler(LastNameNotNullException.class)
    public ResponseEntity<Map<String, String>> handleLastNameNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.LAST_NAME_NULL.getMessage()));
    }

    @ExceptionHandler(EmailNotNullException.class)
    public ResponseEntity<Map<String, String>> handleEmailNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_NULL.getMessage()));
    }

    @ExceptionHandler(IdentityDocumentNotNullException.class)
    public ResponseEntity<Map<String, String>> handleIdentityDocumentNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.IDENTITY_DOCUMENT_NULL.getMessage()));
    }

    @ExceptionHandler(PasswordNotNullException.class)
    public ResponseEntity<Map<String, String>> handlePasswordNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PASSWORD_NULL.getMessage()));
    }

    @ExceptionHandler(ImageNotNullException.class)
    public ResponseEntity<Map<String, String>> handleImageNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.IMAGE_NULL.getMessage()));
    }

    @ExceptionHandler(PhoneNotNullException.class)
    public ResponseEntity<Map<String, String>> handlePhoneNotNullException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PHONE_NULL.getMessage()));
    }

    //Invalid email error
    @ExceptionHandler(InvalidEmailFormatException.class)
    public ResponseEntity<Map<String, String>> handleInvalidEmailFormatException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_EMAIL.getMessage()));
    }

    //Lenght phone error
    @ExceptionHandler(PhoneMaxCharactersException.class)
    public ResponseEntity<Map<String, String>> handlePhoneMaxCharactersException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PHONE_MAX_LENGHT.getMessage()));
    }

    //error that there are letters on the identity document
    @ExceptionHandler(InvalidIdentityDocumentFormatException.class)
    public ResponseEntity<Map<String, String>> handleInvalidIdentityDocumentFormatException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.IDENTITY_DOCUMENT_CONTANIN_LETTER.getMessage()));
    }

    @ExceptionHandler(FailedVerificationGoogleException.class)
    public ResponseEntity<Map<String, String>> handleFailedVerificationGoogleException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.FAILED_VERIFICATION_GOOGLE.getMessage()));
    }

    @ExceptionHandler(URLCloudinayInvalidException.class)
    public ResponseEntity<Map<String, String>> handleURLCloudinayInvalidException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.URL_INVALID.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(UserEmailNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserEmailNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_EMAIL_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentialsException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                body(Collections.singletonMap(MESSAGE, ExceptionResponse.BAD_CREDENTIALS.getMessage()));
    }

    @ExceptionHandler(EmailSendingException.class)
    public ResponseEntity<Map<String, String>> handleEmailException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(UploadImageCloudinaryException.class)
    public ResponseEntity<Map<String, String>> handleUploadImageCloudinaryException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.UPLOAD_IMAGE_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(DeleteImageClodinaryException.class)
    public ResponseEntity<Map<String, String>> handleDeleteImageClodinaryException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DELETE_IMAGE_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTokenException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_TOKEN_EXCEPTION.getMessage()));
    }

}
