package com.kardex.domain.spi;

public interface IEmailPersistencePort {

    void sendEmail(String email, String token);
}
