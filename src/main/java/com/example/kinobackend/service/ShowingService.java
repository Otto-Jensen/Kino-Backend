package com.example.kinobackend.service;

import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    @Autowired
    ShowingRepository showingRepository;

    public List<Showing> getShowingByMovieId(Integer movieId){
        return showingRepository.findByMovieMovieId(movieId);
    }
}
