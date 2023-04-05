package com.restaurent.microservice.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
	
    @Id
    @GeneratedValue(generator = "foodorder_seq", strategy = GenerationType.AUTO)
	private Long id;
	
    private Double total;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<FoodMenu> foodMenu;
	
	//@OneToOne
	//private RoomDetails roomDetails;


	
}
