package com.kardex.application.handler.user;

import com.kardex.application.dto.UserRequest;
import com.kardex.application.dto.UserResponse;
import com.kardex.application.dto.UserUpdateRequest;
import com.kardex.application.handler.cloudinary.ICloudinaryHandler;
import com.kardex.application.mapper.UserMapper;
import com.kardex.domain.api.IUserAccountServicePort;
import com.kardex.domain.model.User;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
@Transactional
public class UserAccountHandler implements IUserAccountHandler {

    private final IUserAccountServicePort userAccountServicePort;
    private final UserMapper userMapper;
    private final ICloudinaryHandler cloudinaryHandler;

    @Override
    public void createUserAccount(UserRequest userRequest, MultipartFile image) {
        String imageUrl = cloudinaryHandler.uploadImage(image);

        User user = userMapper.toUser(userRequest);
        user.setImageUrl(imageUrl);
        userAccountServicePort.createUserAccount(user);
    }

    @Override
    public void updateUser(String userId, UserUpdateRequest userRequest) {
        userAccountServicePort.updateUser(userId, userMapper.toUser(userRequest));
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userAccountServicePort.getUserByEmail(email);
        return userMapper.toResponse(user);
    }

    @Override
    public void updateUserImage(String userId, MultipartFile image) {
        User oldUser = userAccountServicePort.getUserById(userId);

        String imageUrl = oldUser.getImageUrl();

        if (image != null && !image.isEmpty()) {
            if (cloudinaryHandler.deleteFileByUrl(imageUrl)) {
                imageUrl = cloudinaryHandler.uploadImage(image);
            }
        }

        userAccountServicePort.updateUserImage(userId, imageUrl);

    }
}
