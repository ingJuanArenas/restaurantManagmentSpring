package com.restaurant.restaurantmanagment.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restaurantmanagment.model.vo.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername (String username);

}
