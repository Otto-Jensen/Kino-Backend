package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByShowing_ShowingId(Integer showingId);
}
