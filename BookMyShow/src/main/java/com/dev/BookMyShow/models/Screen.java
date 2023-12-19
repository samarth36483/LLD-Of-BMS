package com.dev.BookMyShow.models;

import java.util.List;

import com.dev.BookMyShow.models.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
	private String name;
	
	@OneToMany
	private List<Seat> seats;
	
	// **since feature is an Enum, to create its table in DB we use different annotations
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection  // mapping table for screen to features
	private List<Feature> features;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}
