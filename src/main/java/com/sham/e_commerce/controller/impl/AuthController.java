package com.sham.e_commerce.controller.impl;


import com.sham.e_commerce.domain.dto.AuthResponse;
import com.sham.e_commerce.domain.dto.LoginRequest;
import com.sham.e_commerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        UserDetails userDetails = authService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        String token= authService.generateToken(userDetails);
        AuthResponse response= AuthResponse.builder()
                .token(token).expireIn(86400).build();

        return  ResponseEntity.ok(response);
    }
}
