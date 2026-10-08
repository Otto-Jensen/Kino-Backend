package com.example.kinobackend.controller;


import com.example.kinobackend.model.Showing;
import com.example.kinobackend.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showings")
@CrossOrigin("*")
public class ShowingRestController {

    @Autowired
    ShowingService showingService;

    @GetMapping("/movie/{movieId}")
    public List<Showing> getShowingByMovieId(@PathVariable Integer movieId){
        return showingService.getShowingByMovieId(movieId);
    }

    @DeleteMapping("/{showingId}")
    public void deleteShowing(@PathVariable Integer showingId){
        showingService.deleteShowing(showingId);
    }
}
