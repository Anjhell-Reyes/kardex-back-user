package com.kardex.infrastructure.configuration;

import com.kardex.infrastructure.util.ApiConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(ApiConstants.CORS.ALLOWED_PATHS)
                .allowedOrigins(ApiConstants.CORS.ALLOWED_ORIGINS)
                .allowedMethods(ApiConstants.CORS.ALLOWED_METHODS);
    }
}
