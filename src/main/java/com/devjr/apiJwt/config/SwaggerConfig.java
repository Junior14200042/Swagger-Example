package com.devjr.apiJwt.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info =@Info(
                title = "API INVENTORY",
                description = "API manages a product and category table with JWT authentication, providing secure access",
                termsOfService = "https://github.com/Junior14200042",
                version = "1.0.0",
                contact = @Contact(
                        name="Junior Cañari",
                        url = "https://github.com/Junior14200042",
                        email = "juniorc14200042@gmail.com"
                ),
                license = @License(
                        name="Standard Software Use License for DevJR",
                        url = "https://github.com/Junior14200042"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url="http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://devjr:8080"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name="Security Token",
        description = "Access Token for My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in= SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {



}
