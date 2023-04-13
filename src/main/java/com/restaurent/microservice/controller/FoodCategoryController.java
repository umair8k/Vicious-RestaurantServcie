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
import org.springframework.web.bind.annotation.RestController;
import com.restaurent.microservice.entity.FoodCategory;
//import com.restaurent.microservice.repository.FoodCategoryRepository;
import com.restaurent.microservice.service.FoodCategoryService;
@RestController
public class FoodCategoryController {

//	@Autowired
//	private FoodCategoryRepository foodCategoryRepository;
	
	@Autowired
	private FoodCategoryService foodCategoryService;
	 
    @PostMapping("/FoodCategory")
      public ResponseEntity<FoodCategory> saveFoodCategory( @RequestBody FoodCategory foodCategory)
      {
          System.out.println("Save FoodCategory>>>>>>>>>>>>>>>>>>>>>>");
          
         return new ResponseEntity<>(foodCategoryService.timeLimit( foodCategory), HttpStatus.CREATED);
}
    
    
  
  @DeleteMapping("/deleteByFoodCategoryId/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteByFoodCategoryId(@PathVariable Long id) {
	  foodCategoryService.deleteByFoodCategoryId(id);
      Map<String, Boolean> map = new HashMap<>();
      map.put("success", true);
      return new ResponseEntity<>(map, HttpStatus.OK);
  }
  
  
  

@GetMapping("/getAllFoodCategory")
public ResponseEntity<List<FoodCategory>> allFoodCategory(){
		List<FoodCategory> allFoodCategory= foodCategoryService.findAll();
		return new ResponseEntity<List<FoodCategory>>(allFoodCategory, HttpStatus.ACCEPTED);
	
}
@PutMapping("/updateFoodCategory/{id}")

public ResponseEntity<Map<String, Boolean>> updateFoodCategory(@PathVariable Long id,
                                                        @RequestBody FoodCategory foodCategory) {
	foodCategory.setId(id);
	foodCategoryService.updateFoodCategory(foodCategory);
    Map<String, Boolean> map = new HashMap<>();
    map.put("success", true);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
}



@GetMapping("/getByFoodCategoryId/{id}")
public ResponseEntity<FoodCategory> getByHotelNamesId(@PathVariable Long id) {
	FoodCategory foodCategory = foodCategoryService.findById(id);
    return new ResponseEntity<>(foodCategory, HttpStatus.OK);
}
}