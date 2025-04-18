package com.kardex.infrastructure.output.mapper;

import com.kardex.domain.model.User;
import com.kardex.infrastructure.output.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toUser(UserEntity userEntity);

    // Método para actualizar una entidad existente sin sobrescribir valores nulos
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserEntity(@MappingTarget UserEntity userEntity, User user);
}
