package com.example.kinobackend.service;

import com.example.kinobackend.model.Movie;
import com.example.kinobackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }



}
