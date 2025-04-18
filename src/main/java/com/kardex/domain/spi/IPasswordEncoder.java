package com.kardex.domain.spi;

public interface IPasswordEncoder {
    String encryptPassword(String plainPassword);
}
