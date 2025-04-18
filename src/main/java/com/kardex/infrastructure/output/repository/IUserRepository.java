package com.kardex.infrastructure.output.repository;

import com.kardex.infrastructure.output.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface IUserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByResetToken(String token);
}