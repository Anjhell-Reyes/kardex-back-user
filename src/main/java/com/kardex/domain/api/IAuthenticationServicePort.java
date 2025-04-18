package com.kardex.domain.api;

import com.kardex.domain.model.authentication.Authentication;
import com.kardex.domain.model.authentication.AuthenticationResponse;

public interface IAuthenticationServicePort {
    AuthenticationResponse authenticate(Authentication authentication);

    AuthenticationResponse loginWithGoogle(String idToken);
}
