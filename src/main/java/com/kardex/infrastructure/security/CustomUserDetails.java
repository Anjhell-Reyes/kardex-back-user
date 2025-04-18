package com.kardex.infrastructure.security;

import com.kardex.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User userAccount;

    public CustomUserDetails(User userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Si no manejas roles, simplemente retorna una lista vacía.
        return Collections.emptyList();
    }

    public String getUserId() {
        return userAccount.getId();
    }

    public String getCompanyName() {
        return  userAccount.getCompanyName();
    }
}
