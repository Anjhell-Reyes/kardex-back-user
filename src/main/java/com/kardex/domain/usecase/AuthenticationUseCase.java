package com.kardex.domain.usecase;

import com.kardex.domain.api.IAuthenticationServicePort;
import com.kardex.domain.model.authentication.GoogleUserInfo;
import com.kardex.domain.model.User;
import com.kardex.domain.model.authentication.Authentication;
import com.kardex.domain.model.authentication.AuthenticationResponse;
import com.kardex.domain.spi.IAuthenticationPersistencePort;
import com.kardex.domain.spi.IJwtServicePersistencePort;
import com.kardex.domain.spi.IUserAccountPersistencePort;
import com.kardex.domain.spi.IVerifyGoogleIdTokenPersistencePort;

import java.util.Optional;

public class AuthenticationUseCase implements IAuthenticationServicePort {

    private final IAuthenticationPersistencePort authenticationPersistencePort;
    private final IUserAccountPersistencePort userAccountPersistencePort;
    private final IJwtServicePersistencePort jwtServicePersistencePort;
    private final IVerifyGoogleIdTokenPersistencePort googleVerifier;

    public AuthenticationUseCase(IAuthenticationPersistencePort authenticationPersistencePort, IUserAccountPersistencePort userAccountPersistencePort, IJwtServicePersistencePort jwtServicePersistencePort, IVerifyGoogleIdTokenPersistencePort googleVerifier) {
        this.authenticationPersistencePort = authenticationPersistencePort;
        this.userAccountPersistencePort = userAccountPersistencePort;
        this.jwtServicePersistencePort = jwtServicePersistencePort;
        this.googleVerifier = googleVerifier;
    }

    @Override
    public AuthenticationResponse authenticate(Authentication authentication) {

        authenticationPersistencePort.authenticate(authentication.getEmail(), authentication.getPassword());

        User user = userAccountPersistencePort.getUserByEmail(authentication.getEmail());
        var jwtToken = jwtServicePersistencePort.generate(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse loginWithGoogle(String idToken) {
        GoogleUserInfo googleUserInfo = googleVerifier.verify(idToken);

        Optional<User> optionalUser = userAccountPersistencePort.findUserByEmail(googleUserInfo.getEmail());

        User user = optionalUser.orElseGet(() -> {
            User newUser = new User(
                    null,
                    googleUserInfo.getName(),
                    googleUserInfo.getGivenName(),
                    googleUserInfo.getPicture(),
                    googleUserInfo.getEmail(),
                    null
            );
            return userAccountPersistencePort.saveUserAccount(newUser);
        });

        var jwtToken = jwtServicePersistencePort.generate(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }
}
