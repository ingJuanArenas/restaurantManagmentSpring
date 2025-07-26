package com.restaurant.restaurantmanagment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantmanagment.model.dto.request.DishRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.DishResponse;
import com.restaurant.restaurantmanagment.service.impl.DishServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DishController {
    
    private final DishServiceImpl ds;


    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/dishes")
    public List<DishResponse> getAllDishes() {
        return ds.getAll();
    }
    @ResponseStatus(HttpStatus.OK)
     @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/dishes/search")
    public List<DishResponse> getDish(@RequestParam String text) {
        return ds.get(text);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/dishes")
    public DishResponse saveNewDish(@RequestBody DishRequest dr) {
        return ds.saveNew(dr);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id) {
        ds.delete(id);
    }

    

    
}
