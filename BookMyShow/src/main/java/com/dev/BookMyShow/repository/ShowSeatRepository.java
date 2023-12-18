package com.dev.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BookMyShow.models.ShowSeat;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
	
	Optional<ShowSeat> findById(Long id);
	
	ShowSeat save(ShowSeat showSeat);

}
