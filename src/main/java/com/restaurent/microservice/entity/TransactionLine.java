package com.restaurent.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TransactionLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Long foodMenuId;
	private Long userId;
	private Long transactionId;
	private Long isCancelledId;
	private String cancleReasonDes;
	private Long cancleReasonId;
	private String cancellationMovement;
	private Double refundedAmount;
	
}
