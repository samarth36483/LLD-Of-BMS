package com.dev.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BookMyShow.exception.TicketNotFoundException;
import com.dev.BookMyShow.models.ShowSeat;
import com.dev.BookMyShow.models.Ticket;
import com.dev.BookMyShow.models.User;
import com.dev.BookMyShow.models.enums.BookingStatus;
import com.dev.BookMyShow.models.enums.ShowSeatStatus;
import com.dev.BookMyShow.repository.ShowRepository;
import com.dev.BookMyShow.repository.ShowSeatRepository;
import com.dev.BookMyShow.repository.TicketRepository;
import com.dev.BookMyShow.repository.UserRepository;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShowRepository showRepository;
	@Autowired
	private ShowSeatRepository showSeatRepository;

	@Override
	public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {
		
		return null;
	}

	@Override
	public Ticket cancelTicket(Long ticketId) {
		Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
		
		if(ticketOptional.isEmpty()) {
			throw new TicketNotFoundException("No ticket found");
		}
		Ticket ticket = ticketOptional.get();
		ticket.setStatus(BookingStatus.CANCELLED);
		
		List<ShowSeat> seats = ticket.getSeats();
		for(ShowSeat seat : seats) {
			seat.setStatus(ShowSeatStatus.AVAILABLE);
		}
		
		ticketRepository.save(ticket);
		
		return ticket;
	}

	@Override
	public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
