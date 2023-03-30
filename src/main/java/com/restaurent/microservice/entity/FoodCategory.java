package com.restaurent.microservice.entity;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FoodCategory {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	   
	    private String foodCategory;
	    private LocalTime startTime;
	    private LocalTime endTime;

}
	 
