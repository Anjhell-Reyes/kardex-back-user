package com.kardex.domain.spi;

import com.kardex.domain.model.User;

import java.util.Optional;

public interface IUserAccountPersistencePort {

    User saveUserAccount(User user);

    void updateUser(User user);

    User getUserByEmail(String email);

    Optional<User> findUserByEmail(String email);

    User getUserById(String userId);

    User findByResetToken(String token);
}

