package com.devjr.apiJwt.jwtConfig;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
}
