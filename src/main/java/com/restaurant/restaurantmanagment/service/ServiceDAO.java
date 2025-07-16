package com.restaurant.restaurantmanagment.service;

import java.util.List;

public abstract class ServiceDAO <VO,RQ,RS> {


public abstract  List<RS> getAllDishes();
public abstract List<RS> getDish(String text);
public abstract RS saveNewDish(RQ rq);
public abstract  void deleteDish(Long id);

public abstract RS toResponse(VO vo);
public abstract VO toEntity(RQ rq);
}
