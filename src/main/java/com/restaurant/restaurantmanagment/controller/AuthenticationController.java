package com.restaurant.restaurantmanagment.controller;

import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantmanagment.model.dto.request.AuthenticationRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.AuthenticationResponse;
import com.restaurant.restaurantmanagment.service.impl.AuthenticationServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceImpl authService;
    
    
    @PostMapping("/auth")
    public AuthenticationResponse authenticate (@Valid @RequestBody AuthenticationRequest credentials) {
        
        return authService.login(credentials);
    }
    
}
