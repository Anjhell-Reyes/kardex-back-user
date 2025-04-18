package com.kardex.application.mapper;

import com.kardex.application.dto.UserRequest;
import com.kardex.application.dto.UserResponse;
import com.kardex.application.dto.UserUpdateRequest;
import com.kardex.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserRequest userRequest);
    UserResponse toResponse(User user);
    User toUser(UserUpdateRequest userUpdateRequest);
}
