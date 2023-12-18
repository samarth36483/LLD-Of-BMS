package com.dev.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BookMyShow.models.SeatType;
@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
	
	Optional<SeatType> findById(Long SeatTypeId);
	
	SeatType save(SeatType seatType);

}
