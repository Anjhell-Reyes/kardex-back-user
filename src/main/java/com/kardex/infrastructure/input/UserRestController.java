package com.kardex.infrastructure.input;

import com.kardex.application.dto.UserPaginated;
import com.kardex.application.dto.UserRequest;
import com.kardex.application.dto.UserResponse;
import com.kardex.application.dto.UserUpdateRequest;
import com.kardex.application.handler.user.IUserAccountHandler;
import com.kardex.infrastructure.security.CustomUserDetails;
import com.kardex.infrastructure.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(ApiConstants.PATHS.USERS)
@RequiredArgsConstructor
public class UserRestController {
    private final IUserAccountHandler userHandler;

    @Operation(summary = ApiConstants.OPERATIONS.OPERATION_NEW_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_201, description = ApiConstants.Responses.RESPONSE_201_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_400, description = ApiConstants.Responses.RESPONSE_400_DESCRIPTION, content = @Content)
    })
    @PostMapping(ApiConstants.PATHS.USERS_CREATE)
    public ResponseEntity<Void> createUser(@Valid @ModelAttribute UserRequest userRequest, @RequestParam("image") MultipartFile image) {
        userHandler.createUserAccount(userRequest, image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ApiConstants.OPERATIONS.OPERATION_USER_RETURNED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_200_GET_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_400, description = ApiConstants.Responses.RESPONSE_400_DESCRIPTION, content = @Content)
    })
    @GetMapping(ApiConstants.PATHS.USER_GET)
    public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(userHandler.getUserByEmail(userDetails.getUsername()));
    }

    @Operation(summary = ApiConstants.OPERATIONS.OPERATION_UPDATE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_200_UPDATE_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_404, description = ApiConstants.Responses.RESPONSE_404_DESCRIPTION, content = @Content)
    })
    @PutMapping()
    public ResponseEntity<Void> updateUser(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody UserUpdateRequest userRequest) {
        userHandler.updateUser(userDetails.getUserId(), userRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = ApiConstants.OPERATIONS.OPERATION_PATCH_IMAGE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_200_UPDATE_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_404, description = ApiConstants.Responses.RESPONSE_404_DESCRIPTION, content = @Content)
    })
    @PatchMapping(ApiConstants.PATHS.USER_IMAGE_PATH)
    public ResponseEntity<Void> updateUserImage(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestParam("image") MultipartFile image) {
        userHandler.updateUserImage(userDetails.getUserId(), image);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

