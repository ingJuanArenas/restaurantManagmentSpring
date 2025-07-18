package com.restaurant.restaurantmanagment.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.model.dto.request.TableRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.TableResponse;
import com.restaurant.restaurantmanagment.repository.TableRepository;
import com.restaurant.restaurantmanagment.utils.mappers.TableMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TableServiceImpl {

    private final TableRepository tr;
    private final TableMapper tm;
    public List<TableResponse> getAll() {
        return tr.findAll().stream().map(tm::toResponse).toList();
    }

  
    public TableResponse get(Long id) {
        var response = tr.findById(id).orElseThrow(() -> new RuntimeException("Mesa con ID " + id + " no encontrada."));;
        return tm.toResponse(response);
    }

  
    public TableResponse saveNew(TableRequest rq) {
        var entity= tm.toEntity(rq);
        tr.save(entity);
        return tm.toResponse(entity);
    }

  
    public void delete(Long id) {
        tr.deleteById(id);
    }
    
}
