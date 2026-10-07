package com.example.kinobackend.controller;

import com.example.kinobackend.model.Seat;
import com.example.kinobackend.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/showings")
public class ShowingRestController {

    @Autowired
    ShowingService showingService;

    @GetMapping("/{showingId}/available-seats")
    public List<Seat> getAvailableSeats(@PathVariable Integer showingId) {
        return showingService.getAvailableSeatsForShowing(showingId);
    }
}