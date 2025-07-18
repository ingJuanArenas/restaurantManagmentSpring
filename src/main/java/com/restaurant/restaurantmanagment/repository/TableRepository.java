package com.restaurant.restaurantmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restaurantmanagment.model.vo.RestaurantTable;


@Repository
public interface TableRepository extends JpaRepository<RestaurantTable,Long>{

}