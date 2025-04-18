package com.kardex.infrastructure.input;


import com.kardex.application.dto.PasswordResetRequest;
import com.kardex.application.handler.user.IPasswordResetHandler;
import com.kardex.infrastructure.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.PATHS.PASSWORD)
@RequiredArgsConstructor
public class PasswordResetRestController {

    private final IPasswordResetHandler passwordResetHandler;

    @Operation(summary = "send email user to reset password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_201_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_400, description = ApiConstants.Responses.RESPONSE_400_DESCRIPTION, content = @Content)
    })
    @PostMapping(ApiConstants.PATHS.PASSWORD_REQUEST)
    public ResponseEntity<String> requestReset(@RequestParam String email) {
        passwordResetHandler.requestPasswordReset(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "reset password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_201_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_400, description = ApiConstants.Responses.RESPONSE_400_DESCRIPTION, content = @Content)
    })
    @PostMapping(ApiConstants.PATHS.PASSWORD_RESET)
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest passwordResetRequest) {
        passwordResetHandler.resetPassword(passwordResetRequest.getToken(), passwordResetRequest.getNewPassword());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
