package com.kardex.infrastructure.output.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    private String id;

    @NotNull
    private String username;

    @NotNull
    private String companyName;

    @NotNull
    private String imageUrl;

    @NotNull
    private String email;

    private String password;

    private String resetToken;
}
