package com.restaurant.restaurantmanagment.service;

import java.util.List;

public abstract class ServiceDAO <VO,RQ,RS> {


public abstract  List<RS> getAll();
public abstract List<RS> get(String text);
public abstract RS saveNew(RQ rq);
public abstract  void delete(Long id);

}
