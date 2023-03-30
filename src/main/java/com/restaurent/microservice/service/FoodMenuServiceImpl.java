package com.restaurent.microservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurent.microservice.entity.FoodMenu;
import com.restaurent.microservice.exception.BadRequestException;
import com.restaurent.microservice.exception.ResourceNotFoundException;
import com.restaurent.microservice.repository.FoodMenuRepository;

@Service
public class FoodMenuServiceImpl implements FoodMenuService{

	@Autowired
	private FoodMenuRepository foodMenuRepository;
	@Override
	public void deleteByFoodMenuId(Long id) {
		foodMenuRepository.deleteById(id);
	}

	@Override
	public List<FoodMenu> findAll() {
		
		return foodMenuRepository.findAll();
	}

	@Override
	public void updateFoodMenu(FoodMenu foodMenu) throws BadRequestException{
		try {
			foodMenuRepository.save(foodMenu);
        } catch (Exception e) {
            throw new BadRequestException("invalid request");
        }
        }
	@Override
	public FoodMenu findById(Long id) throws ResourceNotFoundException {
        return foodMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("709","resource not found"));
    }


}
