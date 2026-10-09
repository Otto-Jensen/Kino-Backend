package com.example.kinobackend.controller;

import com.example.kinobackend.model.Movie;
import com.example.kinobackend.repositories.MovieRepository;
import com.example.kinobackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/movies")

public class MovieRestController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
}

