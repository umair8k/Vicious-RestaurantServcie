package com.restaurent.microservice.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.microservice.entity.FoodCategory;
import com.restaurent.microservice.exception.BadRequestException;
import com.restaurent.microservice.exception.ResourceNotFoundException;
import com.restaurent.microservice.repository.FoodCategoryRepository;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

	@Autowired
	private FoodCategoryRepository foodCategoryRepository;

	@Override
	public void deleteByFoodCategoryId(Long id) {
		foodCategoryRepository.deleteById(id);
		
	}

	@Override
	public List<FoodCategory> findAll() {
		
		return foodCategoryRepository.findAll();
	}

	@Override
	public void updateFoodCategory(FoodCategory foodCategory)throws BadRequestException{
		try {
			foodCategoryRepository.save(foodCategory);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
	} 

	@Override
	public FoodCategory findById(Long id) throws ResourceNotFoundException {
        return foodCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
	                       }

	@Override
	public FoodCategory timeLimit(FoodCategory foodCategory) {
		if(foodCategory.getFoodCategory().equals("Breakfast"))
        {
           foodCategory.setStartTime(LocalTime.of(7, 0, 0));
           foodCategory.setEndTime(LocalTime.of(11, 0, 0));
           foodCategoryRepository.save(foodCategory);
                  return foodCategoryRepository.save(foodCategory);
        }

      if(foodCategory.getFoodCategory().equals("Lunch"))
       {
           foodCategory.setStartTime(LocalTime.of(12, 0, 0));
           foodCategory.setEndTime(LocalTime.of(3, 0, 0));
           foodCategoryRepository.save(foodCategory);
                return foodCategoryRepository.save(foodCategory);
       }
     if(foodCategory.getFoodCategory().equals("Dinner"))
       {
           foodCategory.setStartTime(LocalTime.of(8, 0, 0));
           foodCategory.setEndTime(LocalTime.of(11, 0, 0));
           foodCategoryRepository.save(foodCategory);
                return foodCategoryRepository.save(foodCategory);
       }
    else {
               System.out.println("CANNOT ORDER");

         }

                         return foodCategoryRepository.save(foodCategory);
          }
}