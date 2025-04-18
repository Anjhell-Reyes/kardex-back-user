package com.kardex.domain.spi;

import com.kardex.domain.model.authentication.GoogleUserInfo;

public interface IVerifyGoogleIdTokenPersistencePort {
    GoogleUserInfo verify(String idToken);
}
