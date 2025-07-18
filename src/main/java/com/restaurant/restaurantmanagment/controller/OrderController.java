package com.restaurant.restaurantmanagment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantmanagment.model.dto.request.OrderRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.OrderResponse;
import com.restaurant.restaurantmanagment.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderController {
    
    private final OrderServiceImpl os;

    @GetMapping("/orders")
    public List<OrderResponse> getAllOrders() {
        return os.getAll();
    }
    @GetMapping("/orders/search")
    public List<OrderResponse> getOrder(@RequestParam String text) {
        return os.get(text);
    }

    @PostMapping("/orders")
    public OrderResponse saveNewOrder(@RequestBody OrderRequest dr) {
        return os.saveNew(dr);
    }


    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        os.delete(id);
    }

    
}
