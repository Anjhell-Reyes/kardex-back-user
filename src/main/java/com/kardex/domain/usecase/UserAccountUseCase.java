package com.kardex.domain.usecase;

import com.kardex.domain.api.IUserAccountServicePort;
import com.kardex.domain.exception.*;
import com.kardex.domain.model.User;
import com.kardex.domain.spi.IPasswordEncoder;
import com.kardex.domain.spi.IUserAccountPersistencePort;
import com.kardex.domain.util.DomainConstants;

public class UserAccountUseCase implements IUserAccountServicePort {

    private final IUserAccountPersistencePort userAccountPersistencePort;
    private final IPasswordEncoder passwordEncoder;

    public UserAccountUseCase(IUserAccountPersistencePort userAccountPersistencePort, IPasswordEncoder passwordEncoder) {
        this.userAccountPersistencePort = userAccountPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUserAccount(User user) {
        // Validar campos requeridos
        if (user.getUsername() == null) {
            throw new NameNotNullException();
        }

        if (user.getCompanyName() == null) {
            throw new LastNameNotNullException();
        }

        if (user.getEmail() == null) {
            throw new EmailNotNullException();
        }

        if (user.getPassword() == null) {
            throw new PasswordNotNullException();
        }

        if (user.getImageUrl() == null) {
            throw new IdentityDocumentNotNullException();
        }

        // Validar formato de email
        if (!isValidEmail(user.getEmail())) {
            throw new InvalidEmailFormatException();
        }

        // Encriptar contraseña
        user.setPassword(passwordEncoder.encryptPassword(user.getPassword()));

        return userAccountPersistencePort.saveUserAccount(user);
    }

    @Override
    public void updateUser(String userId, User user) {
        User oldUser = userAccountPersistencePort.getUserById(userId);

        user.setId(oldUser.getId());
        user.setUsername(copyIfNull(user.getUsername(), oldUser.getUsername()));
        user.setCompanyName(copyIfNull(user.getCompanyName(), oldUser.getCompanyName()));
        user.setImageUrl(oldUser.getImageUrl());
        user.setEmail(copyIfNull(user.getEmail(), oldUser.getEmail()));
        user.setPassword(oldUser.getPassword());

        userAccountPersistencePort.updateUser(user);
    }

    @Override
    public void updateUserImage(String userId, String imageUrl) {
        User user = userAccountPersistencePort.getUserById(userId);

        if (user == null) {
            throw new UserNotFoundException();
        }
        user.setImageUrl(imageUrl);
        userAccountPersistencePort.updateUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userAccountPersistencePort.getUserByEmail(email);
    }

    public User getUserById(String userId) {
        return userAccountPersistencePort.getUserById(userId);}

    private boolean isValidEmail(String email) {
        return DomainConstants.Validations.EMAIL_PATTERN.matcher(email).matches();
    }


    private <T> T copyIfNull(T newValue, T oldValue) {
        return (newValue != null) ? newValue : oldValue;
    }
}
