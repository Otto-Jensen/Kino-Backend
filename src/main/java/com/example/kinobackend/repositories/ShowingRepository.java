package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {

    List<Showing> findByMovieMovieId(Integer movieId);
}