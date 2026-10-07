package com.example.kinobackend.service;


import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowingService {

    @Autowired
    ShowingRepository showingRepository;

    public Showing getShowingById(Integer showingId) {
        return showingRepository.findById(showingId).orElse(null);
    }
}