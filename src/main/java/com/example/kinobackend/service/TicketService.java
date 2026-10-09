package com.example.kinobackend.service;

import com.example.kinobackend.model.Ticket;
import com.example.kinobackend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    public List<Ticket> getTicketsForShowing(Integer showingId) {
        return ticketRepository.findByShowing_ShowingId(showingId);
    }

    public List<Integer> getOccupiedSeatIds(Integer showingId) {

        List<Ticket> tickets = ticketRepository.findByShowing_ShowingId(showingId);

        return tickets.stream()
                .map(ticket -> ticket.getSeat().getSeatId())
                .toList();
    }
}
