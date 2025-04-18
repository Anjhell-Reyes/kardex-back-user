package com.kardex.infrastructure.output.adapter;

import com.kardex.domain.exception.InvalidTokenException;
import com.kardex.domain.exception.UserEmailNotFoundException;
import com.kardex.domain.exception.UserNotFoundException;
import com.kardex.domain.model.User;
import com.kardex.domain.spi.IUserAccountPersistencePort;
import com.kardex.infrastructure.output.entity.UserEntity;
import com.kardex.infrastructure.output.mapper.UserEntityMapper;
import com.kardex.infrastructure.output.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserAccountJpaAdapter implements IUserAccountPersistencePort {

    private final IUserRepository userAccountRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUserAccount(User user) {
        return userEntityMapper.toUser(userAccountRepository.save(userEntityMapper.toEntity(user)));
    }

    @Override
    public void updateUser(User user) {
        userAccountRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity user = userAccountRepository.findByEmail(email)
                .orElseThrow(UserEmailNotFoundException::new);
        return userEntityMapper.toUser(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userAccountRepository.findByEmail(email)
                .map(userEntityMapper::toUser);
    }

    @Override
    public User getUserById(String userId) {
        UserEntity user = userAccountRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userAccountRepository.findById(userId).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User findByResetToken(String token) {
        return userEntityMapper.toUser(userAccountRepository.findByResetToken(token).orElseThrow(InvalidTokenException::new));
    }
}
