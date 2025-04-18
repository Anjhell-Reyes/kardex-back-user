package com.kardex.domain.spi;

public interface IAuthenticationPersistencePort {
    void authenticate(String email, String password);
}
