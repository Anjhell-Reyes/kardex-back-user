package com.kardex.application.handler.user;

import com.kardex.application.dto.UserRequest;
import com.kardex.application.dto.UserResponse;
import com.kardex.application.dto.UserUpdateRequest;
import org.springframework.web.multipart.MultipartFile;

public interface IUserAccountHandler {

    void createUserAccount(UserRequest userRequest, MultipartFile image);

    void updateUser(String userId, UserUpdateRequest userRequest);

    void updateUserImage(String id, MultipartFile image);

    UserResponse getUserByEmail(String email);

}
