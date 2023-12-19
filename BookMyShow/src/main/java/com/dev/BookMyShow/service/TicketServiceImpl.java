package com.dev.BookMyShow.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dev.BookMyShow.exception.ShowSeatNotAvailableException;
import com.dev.BookMyShow.exception.TicketNotFoundException;
import com.dev.BookMyShow.exception.UserNotFoundException;
import com.dev.BookMyShow.models.Payment;
import com.dev.BookMyShow.models.Show;
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
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {
		User bookedByUser = userRepository.findById(userId).get();
		Show show = showRepository.findById(showId).get();
		
		for(Long seatId : showSeatIds) {
			ShowSeat seat = showSeatRepository.findById(seatId).get();
			if(seat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
				seat.setStatus(ShowSeatStatus.LOCKED);
				showSeatRepository.save(seat);
			}
			else {
				throw new ShowSeatNotAvailableException("Selected seat is already booked");
			}
		}
		
		boolean paymentDone = paymentCheck();
		double amount = 0;
		List<ShowSeat> showSeats = new ArrayList<>();
		if(paymentDone) {
			for(Long seatId : showSeatIds) {
				ShowSeat seat = showSeatRepository.findById(seatId).get();
				seat.setStatus(ShowSeatStatus.BOOKED);
				seat = showSeatRepository.save(seat);
				showSeats.add(seat);
				amount = amount + seat.getPrice();
			}
		}
		
		return ticketGenerator(bookedByUser, amount, showSeats, show);
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
		
		for(Payment p : ticket.getPayments()) {
			int refNo = p.getRefNo();
			// send refNo to 3rd party to process refund against it
		}
		
		ticket = ticketRepository.save(ticket);
		
		return ticket;
	}

	@Override
	public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {
		Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
		
		if(ticketOptional.isEmpty()) {
			throw new TicketNotFoundException("Invalid ticket Id");
		}
		
		Ticket ticket = ticketOptional.get();
		
		Optional<User> fromUserOptional = userRepository.findById(fromUserId);
		Optional<User> toUserOptional = userRepository.findById(toUserId);
		
		if(fromUserOptional.isEmpty() || toUserOptional.isEmpty()) {
			throw new UserNotFoundException("Invalid user");
		}
		
		User fromUser = fromUserOptional.get();
		List<Ticket> fromUserBookingHistory = fromUser.getTickets();
		fromUserBookingHistory.remove(ticket);
		fromUser = userRepository.save(fromUser);
		
		User toUser = toUserOptional.get();
		List<Ticket> toUserBookingHistory = toUser.getTickets();
		toUserBookingHistory.add(ticket);
		toUser = userRepository.save(toUser);
		
		ticket.setUser(toUser);
		
		return ticketRepository.save(ticket);
	}
	
	private boolean paymentCheck() {
		return true;
	}
	
	private Ticket ticketGenerator(User user, double amount, List<ShowSeat> seats, Show show) {
		Ticket ticket = new Ticket();
		ticket.setAmount(amount);
		ticket.setCreatedAt(LocalDateTime.now());
		ticket.setSeats(seats);
		ticket.setShow(show);
		ticket.setUser(user);
		ticket.setStatus(BookingStatus.CONFIRMED);
		ticket.setUpdatedAt(LocalDateTime.now());
		return ticket;
	}

}
