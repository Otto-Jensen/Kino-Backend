package com.example.kinobackend.config;

import com.example.kinobackend.model.Movie;
import com.example.kinobackend.model.Cinema;
import com.example.kinobackend.model.Seat;
import com.example.kinobackend.model.Showing;

import com.example.kinobackend.repositories.MovieRepository;
import com.example.kinobackend.repositories.CinemaRepository;
import com.example.kinobackend.repositories.SeatRepository;
import com.example.kinobackend.repositories.ShowingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ShowingRepository showingRepository;

    @Override
    public void run(String... args) {

        // Opret film, hvis de ikke allerede findes
        if (movieRepository.count() == 0) {
            Movie movie1 = new Movie();
            movie1.setName("Dalans dadler");
            movie1.setGenre("Erotik");
            movie1.setDescription("Dalan bruger hans sidste penge på dadler efter han tabte dem alle ved at gamble. Men tilsyneladende er der mere til disse dadler end som lige møder øjet");
            movie1.setAgeLimit(18);

            Movie movie2 = new Movie();
            movie2.setName("Interstellar");
            movie2.setGenre("Science-Fiction");
            movie2.setAgeLimit(15);
            movie2.setDescription("Man der tager til rum for mission for at redde verden: EELLLLLLER!!!?");

            movieRepository.save(movie1);
            movieRepository.save(movie2);
        }

        // Opret biograf, forestilling og sæder, hvis der ikke findes en biograf
        if (cinemaRepository.count() == 0) {

            Cinema cinema = new Cinema();
            cinema.setnumberOfRows(6);
            cinema.setSeatsPerRow(10);
            cinema = cinemaRepository.save(cinema);

            // Brug den første film, der findes i databasen
            Movie movie = movieRepository.findAll().get(0);

            Showing showing = new Showing();
            showing.setMovie(movie);
            showing.setCinema(cinema);
            showing.setDateTime(LocalDateTime.now().plusDays(1));
            showingRepository.save(showing);

            // Opret 6 rækker med 10 sæder i hver række
            for (int row = 1; row <= 6; row++) {
                for (int seatNumber = 1; seatNumber <= 10; seatNumber++) {

                    Seat seat = new Seat();
                    seat.setCinema(cinema);
                    seat.setcinemaRow(row);
                    seat.setSeatNumber(seatNumber);

                    seatRepository.save(seat);
                }
            }
        }
    }
}