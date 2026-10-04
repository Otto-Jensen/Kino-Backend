package com.example.kinobackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Showing {
    public Integer getShowingId() {
        return showingId;
    }

    public void setShowingId(Integer showingId) {
        this.showingId = showingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showingId;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;



}
