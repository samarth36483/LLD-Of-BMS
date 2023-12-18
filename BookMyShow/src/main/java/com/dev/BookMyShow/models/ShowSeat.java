package com.dev.BookMyShow.models;

import com.dev.BookMyShow.models.enums.ShowSeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
	@ManyToOne
	private Show show;
	
	@ManyToOne
	private Seat seat;
	
	@Enumerated(EnumType.ORDINAL)
	private ShowSeatStatus status;
	
	private double price;

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public ShowSeatStatus getStatus() {
		return status;
	}

	public void setStatus(ShowSeatStatus status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}