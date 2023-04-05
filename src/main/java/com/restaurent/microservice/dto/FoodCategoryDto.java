package com.restaurent.microservice.dto;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto {

	private Long id;
	   
    private String foodCategory;
    private LocalTime startTime;
    private LocalTime endTime;
}
