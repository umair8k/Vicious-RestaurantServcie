package com.restaurent.microservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.microservice.entity.FoodCategory;
import com.restaurent.microservice.entity.FoodMenu;
import com.restaurent.microservice.repository.FoodCategoryRepository;
import com.restaurent.microservice.repository.FoodMenuRepository;
import com.restaurent.microservice.service.FoodMenuService;


@RestController
//@RequestMapping("/restaurant")
public class FoodMenuController {
	
	@Autowired
	private FoodMenuRepository foodMenuRepository;
	
	@Autowired
	private FoodMenuService foodMenuService;
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepository;
	
	 @PostMapping("/FoodMenu")
     public ResponseEntity<FoodMenu> saveFoodMenu( @RequestBody FoodMenu foodMenu,@RequestParam Long id)
     {
		 FoodCategory foodCategory = foodCategoryRepository.findById(id).get();
		 foodMenu.setFoodCategory(foodCategory); 
         System.out.println("Save FoodMenu>>>>>>>>>>>>>>>>>>>>>>");
         
        return new ResponseEntity<>(foodMenuRepository.save( foodMenu), HttpStatus.CREATED);
}
	   @DeleteMapping("/deleteByFoodMenuId/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteByFoodMenuId(@PathVariable Long id) {
		   foodMenuService.deleteByFoodMenuId(id);
	        Map<String, Boolean> map = new HashMap<>();
	        map.put("success", true);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
	    
	@GetMapping("/getAllFoodMenu")
	public ResponseEntity<List<FoodMenu>> allFoodMenu(){
			List<FoodMenu> allFoodMenu= foodMenuService.findAll();
			return new ResponseEntity<List<FoodMenu>>(allFoodMenu, HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/updateFoodMenu/{id}")

	public ResponseEntity<Map<String, Boolean>> updateFoodMenu(@PathVariable Long id,
	                                                        @RequestBody FoodMenu foodMenu) {
		foodMenu.setId(id);
		foodMenuService.updateFoodMenu(foodMenu);
	    Map<String, Boolean> map = new HashMap<>();
	    map.put("success", true);
	    return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/getByFoodMenuId/{id}")
	public ResponseEntity<FoodMenu> getByFoodMenuId(@PathVariable Long id) {
		FoodMenu foodMenu = foodMenuService.findById(id);
	    return new ResponseEntity<>(foodMenu, HttpStatus.OK);
	}
}