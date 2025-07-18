package com.restaurant.restaurantmanagment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.restaurant.restaurantmanagment.model.dto.request.TableRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.TableResponse;
import com.restaurant.restaurantmanagment.service.impl.TableServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RequestMapping("api/tables")
@RestController
@RequiredArgsConstructor
public class TableController {
    
    private final TableServiceImpl ts;

    @GetMapping("/")
    public String test() {
        return new String("Funcionando.......");
    }

    @GetMapping()
    public List<TableResponse> getAll() {
        return ts.getAll();
    }


    @GetMapping("/{id}")
    public TableResponse getById(@PathVariable Long id){
        return ts.get(id);
    }
    

     @PostMapping()
    public TableResponse saveNewTable(@RequestBody TableRequest tr) {
        return ts.saveNew(tr);
    }


    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        ts.delete(id);
    }



    
}
