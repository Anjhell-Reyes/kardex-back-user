package com.kardex.infrastructure.exceptionHandler;

import com.kardex.domain.util.DomainConstants;

public enum ExceptionResponse {
    NAME_NULL("Name must not be null"),
    LAST_NAME_NULL("Last name must not be null"),
    IMAGE_NULL("Image must not be null"),
    BIRTHDATE_NULL("Birthdate must not be null"),
    EMAIL_NULL("Email must not be null"),
    IDENTITY_DOCUMENT_NULL("Identity document must not be null"),
    PHONE_NULL("Phone must not be null"),
    PASSWORD_NULL("Password not be null"),
    INVALID_EMAIL("The email format is invalid"),
    PHONE_MAX_LENGHT("Phone must be " + DomainConstants.Validations.MAX_LENGHT_PHONE + " characters or less"),
    IDENTITY_DOCUMENT_CONTANIN_LETTER("The identity document must contain only numbers"),
    USER_NOT_FOUND("User not found"),
    USER_EMAIL_NOT_FOUND("User email not found"),
    BAD_CREDENTIALS("Incorrect username or password"),
    EMAIL_EXCEPTION("Error sending email"),
    INVALID_TOKEN_EXCEPTION("Invalid token"),
    FAILED_VERIFICATION_GOOGLE("Google verification failed"),
    UPLOAD_IMAGE_EXCEPTION("Error uploading image"),
    DELETE_IMAGE_EXCEPTION("Error deleting image"),
    URL_INVALID("url is invalid"),;
    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
