package com.restaurant.restaurantmanagment.model.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@ManyToOne
@JoinColumn(name = "order_id")
private Order order;

 @ManyToOne
@JoinColumn(name = "dish_id")
private Dish dish;

@Column(nullable = false)
Integer quantity;
@Column(nullable = false)
Double subtotal; 

}
