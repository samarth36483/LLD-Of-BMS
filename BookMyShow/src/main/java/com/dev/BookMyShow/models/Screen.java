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

}
