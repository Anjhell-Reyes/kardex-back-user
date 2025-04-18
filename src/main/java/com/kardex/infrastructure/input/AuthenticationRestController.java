package com.kardex.infrastructure.input;

import com.kardex.application.dto.AuthenticationRequest;
import com.kardex.application.dto.GoogleLoginRequest;
import com.kardex.application.handler.authentication.IAuthenticationServiceHandler;
import com.kardex.domain.model.authentication.AuthenticationResponse;
import com.kardex.infrastructure.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.PATHS.AUTH_USER)
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final IAuthenticationServiceHandler authenticationServiceHandler;

    @Operation(summary = "login user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_200, description = ApiConstants.Responses.RESPONSE_200_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = ApiConstants.Responses.RESPONSE_401, description = ApiConstants.Responses.RESPONSE_401_DESCRIPTION, content = @Content),
    })
    @PostMapping(ApiConstants.PATHS.AUTH_LOGIN)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        return  ResponseEntity.ok(authenticationServiceHandler.authenticate(authenticationRequest));
    }

    @PostMapping(ApiConstants.PATHS.GOOGLE_LOGIN)
    public ResponseEntity<AuthenticationResponse> loginConGoogle(@RequestBody GoogleLoginRequest request) {
        return ResponseEntity.ok(authenticationServiceHandler.loginWithGoogle(request));
    }
}
