package com.kardex.infrastructure.configuration;

import com.cloudinary.Cloudinary;
import com.kardex.domain.api.IAuthenticationServicePort;
import com.kardex.domain.api.IPasswordResetServicePort;
import com.kardex.domain.api.IUserAccountServicePort;
import com.kardex.domain.spi.*;
import com.kardex.domain.usecase.AuthenticationUseCase;
import com.kardex.domain.usecase.PasswordResetUseCase;
import com.kardex.domain.usecase.UserAccountUseCase;
import com.kardex.infrastructure.output.adapter.*;
import com.kardex.infrastructure.output.mapper.UserEntityMapper;
import com.kardex.infrastructure.output.repository.IUserRepository;
import com.kardex.infrastructure.security.EncryptPassword;
import com.kardex.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userAccountRepository;
    private final UserEntityMapper userEntityMapper;
    private final AuthenticationManager authenticationManager;
    private final JavaMailSender mailSender;
    private final Cloudinary cloudinary;

    @Bean
    public IUserAccountPersistencePort userAccountPersistencePort() {
        return new UserAccountJpaAdapter(userAccountRepository, userEntityMapper);
    }

    @Bean
    public IUserAccountServicePort userAccountServicePort() {
        return new UserAccountUseCase(userAccountPersistencePort(), passwordEncoder());
    }

    @Bean
    public IPasswordEncoder passwordEncoder() {
        return new EncryptPassword();
    }

    @Bean
    public IVerifyGoogleIdTokenPersistencePort googleVerifier() {
        return new GoogleIdTokenVerifierAdapter();
    }

    @Bean
    public IAuthenticationServicePort authenticationServicePort() {
        return new AuthenticationUseCase(authenticationPersistencePort(),userAccountPersistencePort(),jwtServicePersistencePort(),googleVerifier());
    }

    @Bean
    public IAuthenticationPersistencePort authenticationPersistencePort() {
        return new AuthenticationServiceAdapter(authenticationManager);
    }

    @Bean
    public IImagePersistencePort imagePersistencePort() {
        return new CloudinaryAdapter(cloudinary);
    }

    @Bean
    public IPasswordResetServicePort passwordResetServicePort() {
        return new PasswordResetUseCase(userAccountPersistencePort(), emailPersistencePort(), passwordEncoder());
    }

    @Bean
    public IEmailPersistencePort emailPersistencePort() {
        return new EmailServiceAdapter(mailSender);
    }

    @Bean
    public IJwtServicePersistencePort jwtServicePersistencePort(){
        return new JwtService();
    }

}
