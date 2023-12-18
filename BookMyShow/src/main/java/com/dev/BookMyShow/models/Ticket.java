package com.dev.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.BookMyShow.models.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
	@Enumerated(EnumType.ORDINAL)
	private BookingStatus status;
	
	@ManyToMany
	private List<ShowSeat> seats;
	
	@ManyToOne
	private User user;
	
	private LocalDateTime Showtime;
	
	@ManyToOne
	private Show show;
	
	private double amount;
	
	@OneToMany
	private List<Payment> payments;

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public List<ShowSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<ShowSeat> seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getShowtime() {
		return Showtime;
	}

	public void setShowtime(LocalDateTime showtime) {
		Showtime = showtime;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}