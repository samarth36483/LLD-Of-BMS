package com.dev.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.BookMyShow.models.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
	@ManyToOne
	private Movie movie;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private Screen screen;
	
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection
	private List<Feature> features;
	
	private List<ShowSeat> showSeats;

}
