package com.dev.BookMyShow.models;

import com.dev.BookMyShow.models.enums.PaymentMode;
import com.dev.BookMyShow.models.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
	private int refNo;
	
	private double amount;
	
	@Enumerated(EnumType.ORDINAL)
	private PaymentStatus status;
	
	@Enumerated(EnumType.ORDINAL)
	private PaymentMode paymentMode;
	
}
