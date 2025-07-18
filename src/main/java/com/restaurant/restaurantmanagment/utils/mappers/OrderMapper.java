package com.restaurant.restaurantmanagment.utils.mappers;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.restaurantmanagment.model.dto.request.OrderRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.OrderResponse;
import com.restaurant.restaurantmanagment.model.vo.Order;
import com.restaurant.restaurantmanagment.model.vo.OrderDetail;
import com.restaurant.restaurantmanagment.repository.TableRepository;

@Mapper(componentModel = "spring", uses = {DetailsMapper.class})
public abstract class OrderMapper {

    

    @Autowired
    protected DetailsMapper detailsMapper;

    @Autowired
    protected TableRepository tableRepository;

   public Order toEntity(OrderRequest request) {
    Order entity = new Order();

    var table = tableRepository.findById(request.getTableId())
                               .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
    entity.setTable(table);

    entity.setDate(LocalDate.now());

    var details = detailsMapper.toEntity(request.getDetails());

    for (OrderDetail d : details) {
        d.setOrder(entity);
    }

    entity.setDetails(details);
    return entity;
}


    public OrderResponse toResponse(Order order) {
    var response = new OrderResponse();

    response.setId(order.getId());
    response.setDate(order.getDate());
    response.setTotal(order.getTotal());

    if (order.getTable() != null) {
        response.setTableId(order.getTable().getId());
    }

    response.setDetails(detailsMapper.toResponse(order.getDetails()));

    return response;
}

}
