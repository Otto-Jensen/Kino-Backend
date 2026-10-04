package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
}
