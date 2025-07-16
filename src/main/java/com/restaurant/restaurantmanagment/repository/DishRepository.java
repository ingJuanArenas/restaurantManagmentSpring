package com.restaurant.restaurantmanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.restaurantmanagment.model.vo.Dish;


@Repository
public interface DishRepository extends JpaRepository <Dish, Long> {
    
     @Query("SELECT d FROM Dish d WHERE lower(d.name) like lower(:name)" )
    List<Dish> getAllByName(String name);
}
