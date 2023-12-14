package com.dev.BookMyShow.models;

import com.dev.BookMyShow.models.enums.ShowSeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
	private Show show;
	
	private Seat seat;
	
	@Enumerated(EnumType.ORDINAL)
	private ShowSeatStatus status;
	
	private double price;

}