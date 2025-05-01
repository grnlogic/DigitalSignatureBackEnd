package DigitalSignature.KeamanInformasi.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Digital Signature API",
        version = "1.0",
        description = "API for creating and verifying digital signatures"
    )
)
public class OpenApiConfig {
    // Using annotations instead of a bean to avoid potential compatibility issues
}
