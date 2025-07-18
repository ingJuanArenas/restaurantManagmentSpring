package com.restaurant.restaurantmanagment.service.impl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.model.dto.request.OrderDetailRequest;
import com.restaurant.restaurantmanagment.model.dto.request.OrderRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.OrderResponse;
import com.restaurant.restaurantmanagment.model.vo.Order;
import com.restaurant.restaurantmanagment.model.vo.OrderDetail;
import com.restaurant.restaurantmanagment.repository.DishRepository;
import com.restaurant.restaurantmanagment.repository.OrderRepository;
import com.restaurant.restaurantmanagment.repository.TableRepository;
import com.restaurant.restaurantmanagment.service.ServiceDAO;
import com.restaurant.restaurantmanagment.utils.mappers.OrderMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceDAO<Order,OrderRequest,OrderResponse>{

    private final OrderRepository or;
    private final OrderMapper om;
    private final TableRepository tableRepository;
    private final DishRepository dishRepository;
    
    public List<OrderResponse> getAll() {
        return or.findAll().stream().map(om::toResponse).toList();
    }


    public List<OrderResponse> get(String date) {
        var parsedDate = LocalDate.parse(date);
       return or.getAllByDate(parsedDate).stream().map(om::toResponse).toList();
    }

    public void delete(Long id) {
        or.deleteById(id);
    }

    @Override
      public OrderResponse saveNew(OrderRequest request) {
        var table = tableRepository.findById(request.getTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        List<OrderDetail> details = new ArrayList<>();
        double total = 0.0;

        for (OrderDetailRequest detailReq : request.getDetails()) {
            var dish = dishRepository.findById(detailReq.getDishId())
                    .orElseThrow(() -> new RuntimeException("Dish not found"));

            int quantity = detailReq.getQuantity();
            double subtotal = dish.getPrice() * quantity;
            total += subtotal;
            var detail = new OrderDetail();
            detail.setDish(dish);
            detail.setQuantity(quantity);
            detail.setSubtotal(subtotal);
            details.add(detail);
        }

        var order = new Order();
        order.setTable(table);
        order.setDetails(details);
        order.setTotal(total);
        order.setDate(LocalDate.now());

        // Asegúrate de que cada detalle tenga referencia a la orden (si aplica)
        for (OrderDetail detail : details) {
            detail.setOrder(order);
        }

        var newOrder= or.save(order);

        return om.toResponse(newOrder);
    }

}