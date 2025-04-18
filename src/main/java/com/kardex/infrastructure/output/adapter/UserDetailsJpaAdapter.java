package com.kardex.infrastructure.output.adapter;

import com.kardex.domain.exception.UserNotFoundException;
import com.kardex.domain.model.User;
import com.kardex.infrastructure.exceptionHandler.ExceptionResponse;
import com.kardex.infrastructure.output.mapper.UserEntityMapper;
import com.kardex.infrastructure.output.repository.IUserRepository;
import com.kardex.infrastructure.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsJpaAdapter implements UserDetailsService {

    private final IUserRepository userAccountRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userEntityMapper.toUser(userAccountRepository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException(ExceptionResponse.BAD_CREDENTIALS.getMessage())));

        return new CustomUserDetails(user);
    }
}
