package com.example.kinobackend.service;

import com.example.kinobackend.model.Seat;
import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.SeatRepository;
import com.example.kinobackend.repositories.ShowingRepository;
import com.example.kinobackend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    TicketRepository ticketRepository;

    public List<Seat> getSeatsForShowing(Integer showingId) {
        Showing showing = showingRepository.findById(showingId).orElse(null);

        if (showing == null) {
            return List.of();
        }

        Integer cinemaId = showing.getCinema().getCinemaId();

        return seatRepository.findByCinema_CinemaId(cinemaId);
    }

    public List<Seat> getAvailableSeatsForShowing(Integer showingId) {
        List<Seat> allSeats = getSeatsForShowing(showingId);

        List<Integer> occupiedSeatIds = ticketRepository
                .findByShowing_ShowingId(showingId)
                .stream()
                .map(ticket -> ticket.getSeat().getSeatId())
                .toList();

        return allSeats.stream()
                .filter(seat -> !occupiedSeatIds.contains(seat.getSeatId()))
                .toList();
    }
}