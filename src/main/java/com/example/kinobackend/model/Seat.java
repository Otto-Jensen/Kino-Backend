package com.example.kinobackend.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private int rowNumber;
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    private Cinema cinema;
}
