package com.kardex.application.mapper;

import com.kardex.application.dto.AuthenticationRequest;
import com.kardex.domain.model.authentication.Authentication;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthenticationMapper {

    Authentication toAuthentication(AuthenticationRequest authenticationRequest);
}
