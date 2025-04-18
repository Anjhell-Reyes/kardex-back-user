package com.kardex.application.handler.authentication;

import com.kardex.application.dto.AuthenticationRequest;
import com.kardex.application.dto.GoogleLoginRequest;
import com.kardex.domain.model.authentication.AuthenticationResponse;

public interface IAuthenticationServiceHandler {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse loginWithGoogle(GoogleLoginRequest request);
}
