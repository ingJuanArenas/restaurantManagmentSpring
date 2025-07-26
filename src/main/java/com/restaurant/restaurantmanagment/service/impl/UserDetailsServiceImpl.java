package com.restaurant.restaurantmanagment.service.impl;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.restaurant.restaurantmanagment.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca el usuario en la base de datos por el nombre de usuario
        var user = ur.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Convierte los roles del usuario de tu entidad a GrantedAuthority
        // Spring Security espera GrantedAuthority, SimpleGrantedAuthority es una implementación común.
        var authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role)) // Asumiendo que los roles son "ROLE_USER", "ROLE_ADMIN" etc.
            .toList();

        // Construye y retorna un objeto UserDetails de Spring Security
        // La contraseña ya debe estar codificada en la DB
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            authorities
        );
    }
}

