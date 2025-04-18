package com.kardex.application.dto;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String companyName;
    private String imageUrl;
    private String email;
}
