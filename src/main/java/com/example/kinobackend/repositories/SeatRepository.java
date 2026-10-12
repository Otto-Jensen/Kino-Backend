package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findByCinema_CinemaId(Integer cinemaId);

}