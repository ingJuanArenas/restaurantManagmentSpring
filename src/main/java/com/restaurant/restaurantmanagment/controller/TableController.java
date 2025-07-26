package com.restaurant.restaurantmanagment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.restaurant.restaurantmanagment.model.dto.request.TableRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.TableResponse;
import com.restaurant.restaurantmanagment.service.impl.TableServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
@ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public String test() {
        return new String("Funcionando.......");
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping()
    public List<TableResponse> getAll() {
        return ts.getAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public TableResponse getById(@PathVariable Long id){
        return ts.get(id);
    }
    
@ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('ADMIN')")
     @PostMapping()
    public TableResponse saveNewTable(@RequestBody TableRequest tr) {
        return ts.saveNew(tr);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
      @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        ts.delete(id);
    }



    
}
