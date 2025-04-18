package com.kardex.application.dto;

import com.kardex.application.util.MessageConstants;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotNull(message = MessageConstants.MessageExceptionUserAccount.USERNAME_NOT_NULL_MESSAGE)
    @NotEmpty(message = MessageConstants.MessageExceptionUserAccount.USERNAME_NOT_EMPTY_MESSAGE)
    private String username;

    @NotNull(message = MessageConstants.MessageExceptionUserAccount.COMPANY_NAME_NOT_NULL_MESSAGE)
    @NotEmpty(message = MessageConstants.MessageExceptionUserAccount.COMPANY_NAME_NOT_EMPTY_MESSAGE)
    private String companyName;

    @NotNull(message = MessageConstants.MessageExceptionUserAccount.EMAIL_NOT_NULL_MESSAGE)
    @NotEmpty(message = MessageConstants.MessageExceptionUserAccount.EMAIL_NOT_EMPTY_MESSAGE)
    @Email(message = MessageConstants.MessageExceptionUserAccount.EMAIL_VALID_FORMAT_MESSAGE)
    private String email;

    @NotNull(message = MessageConstants.MessageExceptionUserAccount.PASSWORD_NOT_NULL_MESSAGE)
    @NotEmpty(message = MessageConstants.MessageExceptionUserAccount.PASSWORD_NOT_EMPTY_MESSAGE)
    private String password;
}
