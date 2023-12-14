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

}