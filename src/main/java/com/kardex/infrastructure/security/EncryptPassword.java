package com.kardex.infrastructure.security;

import com.kardex.domain.spi.IPasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

public class EncryptPassword implements IPasswordEncoder {

    @Override
    public String encryptPassword(String passwordPlain){

        String salt = BCrypt.gensalt();

        return BCrypt.hashpw(passwordPlain, salt);
    }

    public EncryptPassword(){

    }
}
