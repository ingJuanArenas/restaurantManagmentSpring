package com.restaurant.restaurantmanagment.service;

import com.restaurant.restaurantmanagment.model.dto.request.AuthenticationRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login (AuthenticationRequest credentials);
}
