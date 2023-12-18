package com.dev.BookMyShow.service;

import java.util.List;

import com.dev.BookMyShow.models.ShowSeat;
import com.dev.BookMyShow.models.Ticket;

public interface TicketService {
	
	Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);
	
	Ticket cancelTicket(Long ticketId);
	
	Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId);

}
