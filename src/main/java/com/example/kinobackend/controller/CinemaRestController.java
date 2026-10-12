package com.example.kinobackend.controller;

import com.example.kinobackend.model.Cinema;
import com.example.kinobackend.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@CrossOrigin("*")
public class CinemaRestController {

    @Autowired
    CinemaRepository cinemaRepository;

     @GetMapping
    public List<Cinema> getCinemas(){
         return cinemaRepository.findAll();
     }
}
