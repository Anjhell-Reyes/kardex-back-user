package com.kardex.application.util;

public class MessageConstants {

    private MessageConstants() {
        // Private constructor to prevent instantiation
    }

    public static final class MessageExceptionUserAccount {

        public static final String USERNAME_NOT_NULL_MESSAGE = "The username cannot be null";
        public static final String USERNAME_NOT_EMPTY_MESSAGE = "The username cannot be empty";

        public static final String COMPANY_NAME_NOT_NULL_MESSAGE = "The company name cannot be null";
        public static final String COMPANY_NAME_NOT_EMPTY_MESSAGE = "The company name cannot be empty";

        public static final String EMAIL_NOT_NULL_MESSAGE = "The email cannot be null";
        public static final String EMAIL_NOT_EMPTY_MESSAGE = "The email cannot be empty";
        public static final String EMAIL_VALID_FORMAT_MESSAGE = "The email must be in a valid format";

        public static final String PASSWORD_NOT_NULL_MESSAGE = "The password cannot be null";
        public static final String PASSWORD_NOT_EMPTY_MESSAGE = "The password cannot be empty";
    }
}
