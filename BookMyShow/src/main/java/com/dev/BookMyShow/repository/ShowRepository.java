package com.dev.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BookMyShow.models.Show;
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	Optional<Show> findById(Long showId);
	
	Show save(Show show);

}
