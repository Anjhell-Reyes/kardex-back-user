package com.kardex.domain.model;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String companyName;
    private String imageUrl;
    private String password;
    private String email;
    private String resetToken;

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public User(String id, String username, String companyName, String imageUrl, String email, String password) {
        this.id = id;
        this.username = username;
        this.companyName = companyName;
        this.imageUrl = imageUrl;
        this.email = email;
        this.password = password;
        this.resetToken = UUID.randomUUID().toString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
