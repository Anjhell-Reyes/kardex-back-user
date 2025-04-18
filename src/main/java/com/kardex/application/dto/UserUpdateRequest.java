package com.kardex.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kardex.application.util.MessageConstants;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserUpdateRequest {
   private String username;

    private String companyName;

    @Email(message = MessageConstants.MessageExceptionUserAccount.EMAIL_VALID_FORMAT_MESSAGE)
    private String email;
}
