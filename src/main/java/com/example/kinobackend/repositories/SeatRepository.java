package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
