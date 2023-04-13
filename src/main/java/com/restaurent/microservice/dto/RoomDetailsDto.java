package com.restaurent.microservice.dto;


import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetailsDto {

	@Id
	private Long id;
	private Double roomPrice;
	private Integer roomNo;
	private String description;
	private boolean roomStatus;
	private boolean isEnable;
	private Integer occupancy;
	
	
}
