package com.kardex.domain.api;

import com.kardex.domain.model.User;

public interface IUserAccountServicePort {

    User createUserAccount(User user);

    void updateUser(String userId, User user);

    void updateUserImage(String userId, String imageUrl);

    User getUserByEmail(String email);

    User getUserById(String userId);
}
