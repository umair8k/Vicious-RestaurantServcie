package com.restaurent.microservice.service;

import java.util.List;
import com.restaurent.microservice.entity.FoodCategory;


public interface FoodCategoryService {

	public void deleteByFoodCategoryId(Long id);

	public List<FoodCategory> findAll();

	public void updateFoodCategory(FoodCategory foodCategory);

	public FoodCategory findById(Long id);
	
	public FoodCategory timeLimit(FoodCategory foodCategory);
}