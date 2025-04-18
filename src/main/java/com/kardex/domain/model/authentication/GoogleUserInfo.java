package com.kardex.domain.model.authentication;

public class GoogleUserInfo {
    private String email;
    private String name;
    private String picture;
    private String givenName;

    public GoogleUserInfo(String email, String name,  String picture, String givenName) {
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {return picture;}

    public void setPicture(String picture) {this.picture = picture;}

    public String getGivenName() {return givenName;}

    public void setGivenName(String givenName) {this.givenName = givenName;}
}
