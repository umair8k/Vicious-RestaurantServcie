package com.restaurent.microservice.dto;

import java.util.List;
import javax.persistence.Id;
import com.restaurent.microservice.entity.FoodMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrderDto {

	

    @Id
	private Long id;
    private Double total;
	private List<FoodMenu> foodMenu;
	private RoomDetailsDto roomDetailsdto;

}
