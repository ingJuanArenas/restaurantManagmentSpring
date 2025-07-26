
package com.restaurant.restaurantmanagment.model.vo;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // ¡Esta contraseña debe estar hasheada!

    // Roles o Autoridades. Puedes usar un String para roles simples
    // o una entidad separada para manejar roles más complejos (relación ManyToMany)
    // Ejemplo simple con String para roles:
    @ElementCollection(fetch = FetchType.EAGER) // Carga los roles inmediatamente
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles; // Ej. "ROLE_USER", "ROLE_ADMIN"
}
