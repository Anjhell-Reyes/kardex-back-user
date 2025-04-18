package com.kardex.application.handler.user;

public interface IPasswordResetHandler {
    void requestPasswordReset(String email);

    void resetPassword(String token, String newPassword);
}
