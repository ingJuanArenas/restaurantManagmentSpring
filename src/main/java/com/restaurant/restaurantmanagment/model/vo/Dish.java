package com.restaurant.restaurantmanagment.model.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "dishes")
public class Dish {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
Long id;

@Column(nullable = false)
String name;
@Column(nullable = false)
Double price;
@Column(nullable = false)
Boolean available;

}
