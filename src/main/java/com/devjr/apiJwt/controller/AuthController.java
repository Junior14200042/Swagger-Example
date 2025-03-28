package com.devjr.apiJwt.controller;

import com.devjr.apiJwt.jwtConfig.AuthRequest;
import com.devjr.apiJwt.jwtConfig.AuthResponse;
import com.devjr.apiJwt.jwtConfig.JwtUtil;
import com.devjr.apiJwt.service.UserDetailServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@Tag(
        name = "Authentication",
        description = "This controller manages user authentication, including login, registration, and token handling for accessing protected resources"
)
public class AuthController {


    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @PostMapping
    ResponseEntity<?> login(@RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );

        String token = jwtUtil.generationToken(authRequest.getUsername());

        AuthResponse authResponse= new AuthResponse(authRequest.getUsername(), token);

        return ResponseEntity.ok(authResponse);
    }
}
