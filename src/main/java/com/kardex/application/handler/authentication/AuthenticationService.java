package com.kardex.application.handler.authentication;

import com.kardex.application.dto.AuthenticationRequest;
import com.kardex.application.dto.GoogleLoginRequest;
import com.kardex.application.mapper.AuthenticationMapper;
import com.kardex.domain.api.IAuthenticationServicePort;
import com.kardex.domain.model.authentication.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationServiceHandler{

    private final IAuthenticationServicePort authenticationServicePort;
    private final AuthenticationMapper authenticationMapper;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        return authenticationServicePort.authenticate(authenticationMapper.toAuthentication(authenticationRequest));
    }

    @Override
    public AuthenticationResponse loginWithGoogle(GoogleLoginRequest request) {
        return authenticationServicePort.loginWithGoogle(request.getIdToken());
    }
}