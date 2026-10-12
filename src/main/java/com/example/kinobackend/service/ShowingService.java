package com.example.kinobackend.service;

import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.ShowingRepository;
import com.example.kinobackend.model.Seat;
import com.example.kinobackend.repositories.SeatRepository;
import com.example.kinobackend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ShowingService {

    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    TicketRepository ticketRepository;

    public List<Showing> getShowingByMovieId(Integer movieId) {
        return showingRepository.findByMovieMovieId(movieId);
    }

    public Showing getShowingById(Integer showingId) {
        return showingRepository.findById(showingId).orElse(null);
    }


    public List<Seat> getSeatsForShowing(Integer showingId) {
        Showing showing = showingRepository.findById(showingId).orElse(null);

        if (showing == null || showing.getCinema() == null) {
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

    public void deleteShowing(Integer showingId){
        showingRepository.deleteById(showingId);
    }

    public Showing createShowing(Showing showing){
        return showingRepository.save(showing);
    }

}