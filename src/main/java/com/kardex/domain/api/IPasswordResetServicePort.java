package com.kardex.domain.api;

public interface IPasswordResetServicePort {
    void requestPasswordReset(String email);
    void resetPassword(String token, String newPassword);
}
