package com.kardex.domain.spi;

import com.kardex.domain.model.User;

public interface IJwtServicePersistencePort {
    String generate(User user);
}
