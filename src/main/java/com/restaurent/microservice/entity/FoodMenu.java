package com.restaurent.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class FoodMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	private String items;
    private Double price;
   
    @ManyToOne
    private FoodCategory foodCategory;
}