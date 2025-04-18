package com.kardex.infrastructure.output.adapter;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.kardex.domain.exception.FailedVerificationGoogleException;
import com.kardex.domain.exception.InvalidTokenException;
import com.kardex.domain.model.authentication.GoogleUserInfo;
import com.kardex.domain.spi.IVerifyGoogleIdTokenPersistencePort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.kardex.infrastructure.util.ApiConstants;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class GoogleIdTokenVerifierAdapter implements IVerifyGoogleIdTokenPersistencePort {

    private final GoogleIdTokenVerifier verifier;

    public GoogleIdTokenVerifierAdapter() {
        this.verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(ApiConstants.CLIENT_ID))
                .build();
    }

    @Override
    public GoogleUserInfo verify(String idToken) {
        try {
            GoogleIdToken token = verifier.verify(idToken);
            if (token == null) throw new InvalidTokenException();

            Payload payload = token.getPayload();
            return new GoogleUserInfo(payload.getEmail(), (String) payload.get("name"), (String) payload.get("picture"), (String) payload.get("given_name"));
        }catch (Exception e) {
            throw new FailedVerificationGoogleException();
        }
    }
}
