package com.restaurent.microservice.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import com.restaurent.microservice.dto.RoomDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    
    
    private Double total;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<FoodMenu> foodMenu;
	
	@Transient
	@OneToOne
	private RoomDetailsDto roomDetailsdto;

}