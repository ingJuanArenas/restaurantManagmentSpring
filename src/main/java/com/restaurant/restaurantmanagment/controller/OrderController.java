package com.restaurant.restaurantmanagment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/orders")  
      @PreAuthorize("hasAuthority('ADMIN')")
    public List<OrderResponse> getAllOrders() {
        return os.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
      @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/orders/search")
    public List<OrderResponse> getOrder(@RequestParam String text) {
        return os.get(text);
    }


    @ResponseStatus(HttpStatus.CREATED)
      @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/orders")
    public OrderResponse saveNewOrder(@RequestBody OrderRequest dr) {
        return os.saveNew(dr);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
  @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        os.delete(id);
    }

    
}
