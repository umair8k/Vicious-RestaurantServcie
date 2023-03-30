package com.restaurent.microservice.service;

import java.util.List;
import com.restaurent.microservice.entity.FoodMenu;


public interface FoodMenuService {
	public void deleteByFoodMenuId(Long id);
	public List<FoodMenu> findAll();
	public void updateFoodMenu(FoodMenu foodMenu);
	public FoodMenu findById(Long id);
}
