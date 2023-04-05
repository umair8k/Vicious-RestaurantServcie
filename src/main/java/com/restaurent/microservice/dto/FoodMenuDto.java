package com.restaurent.microservice.dto;

import com.restaurent.microservice.entity.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenuDto {

private Long id;
    
	private String items;
    private Double price;
    private FoodCategory foodCategory;
}
