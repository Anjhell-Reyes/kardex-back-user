package com.kardex.domain.usecase;

import com.kardex.domain.api.IPasswordResetServicePort;
import com.kardex.domain.exception.InvalidTokenException;
import com.kardex.domain.exception.UserEmailNotFoundException;
import com.kardex.domain.model.User;
import com.kardex.domain.spi.IEmailPersistencePort;
import com.kardex.domain.spi.IPasswordEncoder;
import com.kardex.domain.spi.IUserAccountPersistencePort;

import java.util.UUID;

public class PasswordResetUseCase implements IPasswordResetServicePort {

    private final IUserAccountPersistencePort userAccountPersistencePort;
    private final IEmailPersistencePort emailPersistencePort;
    private final IPasswordEncoder passwordEncoder;

    public PasswordResetUseCase(IUserAccountPersistencePort userAccountPersistencePort, IEmailPersistencePort emailPersistencePort, IPasswordEncoder passwordEncoder) {
        this.userAccountPersistencePort = userAccountPersistencePort;
        this.emailPersistencePort = emailPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void requestPasswordReset(String email) {
        System.out.println(email);
        User user = userAccountPersistencePort.getUserByEmail(email);

        if (user == null) {
            throw new UserEmailNotFoundException();
        }

        String token = UUID.randomUUID().toString();
        user.setResetToken(token);

        userAccountPersistencePort.updateUser(user);

        emailPersistencePort.sendEmail(email, user.getResetToken());
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        User user = userAccountPersistencePort.findByResetToken(token);

        if (user == null) {
            throw new InvalidTokenException();
        }

        user.setPassword(passwordEncoder.encryptPassword(newPassword));
        user.setResetToken(null);

        userAccountPersistencePort.updateUser(user);
    }
}
