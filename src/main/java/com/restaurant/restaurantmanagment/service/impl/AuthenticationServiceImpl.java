
package com.restaurant.restaurantmanagment.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.model.dto.request.AuthenticationRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.AuthenticationResponse;
import com.restaurant.restaurantmanagment.service.AuthenticationService;
import com.restaurant.restaurantmanagment.utils.mappers.JwtUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {
        // llamar al metodo autenticate y autentica si esta bien o no
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        // si esta bien, carga su respectiva info
        var userdetails = userDetailsService.loadUserByUsername(credentials.getUsername());
        // se genera el token con la info cargada
        var jwt = jwtUtil.generateToken(userdetails);

        return new AuthenticationResponse(jwt);
    }
    
}
