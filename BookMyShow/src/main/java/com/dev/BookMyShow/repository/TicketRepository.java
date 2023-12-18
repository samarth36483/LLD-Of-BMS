package com.dev.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BookMyShow.models.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Optional<Ticket> findById(Long ticketId);
	
	Ticket save(Ticket ticket);

}
