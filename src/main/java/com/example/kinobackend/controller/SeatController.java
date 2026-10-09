package com.example.kinobackend.controller;

import com.example.kinobackend.model.Seat;
import com.example.kinobackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin("*")
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping("/showing/{showingId}/available")
    public List<Seat> getAvailableSeats(@PathVariable Integer showingId) {
        return seatService.getAvailableSeatsForShowing(showingId);
    }
}