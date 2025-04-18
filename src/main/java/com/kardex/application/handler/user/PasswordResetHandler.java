package com.kardex.application.handler.user;

import com.kardex.domain.api.IPasswordResetServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PasswordResetHandler implements IPasswordResetHandler {

    private final IPasswordResetServicePort passwordResetServicePort;

    public void requestPasswordReset(String email) {
        passwordResetServicePort.requestPasswordReset(email);
    }

    public void resetPassword(String token, String newPassword) {
        passwordResetServicePort.resetPassword(token, newPassword);
    }
}
