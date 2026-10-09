
package com.example.kinobackend.config;

import com.example.kinobackend.model.Cinema;
import com.example.kinobackend.model.Customer;
import com.example.kinobackend.model.Movie;
import com.example.kinobackend.model.Seat;
import com.example.kinobackend.model.Showing;

import com.example.kinobackend.repositories.CinemaRepository;
import com.example.kinobackend.repositories.CustomerRepository;
import com.example.kinobackend.repositories.MovieRepository;
import com.example.kinobackend.repositories.SeatRepository;
import com.example.kinobackend.repositories.ShowingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) {


        if (customerRepository.count() == 0) {

            Customer customer = new Customer();
            customer.setName("Deniz Dalan");
            customer.setEmail("deniz@example.com");
            customer.setPhone("12345678");

            customerRepository.save(customer);
        }


        if (movieRepository.count() == 0) {

            Movie movie1 = new Movie();
            movie1.setName("Dalans dadler");
            movie1.setGenre("Erotik");
            movie1.setDescription(
                    "Dalan bruger hans sidste penge på dadler efter han tabte dem alle ved at gamble. " +
                            "Men tilsyneladende er der mere til disse dadler end som lige møder øjet"
            );
            movie1.setAgeLimit(18);

            Movie movie2 = new Movie();
            movie2.setName("Interstellar");
            movie2.setGenre("Science-Fiction");
            movie2.setDescription(
                    "Man der tager til rum for mission for at redde verden: EELLLLLLER!!!?"
            );
            movie2.setAgeLimit(15);

            movieRepository.save(movie1);
            movieRepository.save(movie2);
        }


        if (cinemaRepository.count() == 0) {


            Cinema cinema1 = new Cinema();
            cinema1.setnumberOfRows(20);
            cinema1.setSeatsPerRow(12);
            cinema1 = cinemaRepository.save(cinema1);


            Cinema cinema2 = new Cinema();
            cinema2.setnumberOfRows(25);
            cinema2.setSeatsPerRow(16);
            cinema2 = cinemaRepository.save(cinema2);
        }


        if (seatRepository.count() == 0) {

            List<Cinema> cinemas = cinemaRepository.findAll();

            for (Cinema cinema : cinemas) {

                for (int row = 1; row <= cinema.getnumberOfRows(); row++) {

                    for (int seatNumber = 1;
                         seatNumber <= cinema.getSeatsPerRow();
                         seatNumber++) {

                        Seat seat = new Seat();
                        seat.setCinema(cinema);
                        seat.setcinemaRow(row);
                        seat.setSeatNumber(seatNumber);

                        seatRepository.save(seat);
                    }
                }
            }
        }


        if (showingRepository.count() == 0) {

            Movie movie = movieRepository.findAll().get(0);

            List<Cinema> cinemas = cinemaRepository.findAll();

            Cinema cinema1 = cinemas.get(0);
            Cinema cinema2 = cinemas.get(1);

            Showing showing1 = new Showing();
            showing1.setMovie(movie);
            showing1.setCinema(cinema1);
            showing1.setDateTime(LocalDateTime.of(2026, 10, 10, 18, 30));

            Showing showing2 = new Showing();
            showing2.setMovie(movie);
            showing2.setCinema(cinema2);
            showing2.setDateTime(LocalDateTime.of(2026, 10, 10, 19, 30));

            Showing showing3 = new Showing();
            showing3.setMovie(movie);
            showing3.setCinema(cinema1);
            showing3.setDateTime(LocalDateTime.of(2026, 10, 10, 20, 30));

            Showing showing4 = new Showing();
            showing4.setMovie(movie);
            showing4.setCinema(cinema2);
            showing4.setDateTime(LocalDateTime.of(2026, 11, 10, 18, 30));

            Showing showing5 = new Showing();
            showing5.setMovie(movie);
            showing5.setCinema(cinema1);
            showing5.setDateTime(LocalDateTime.of(2026, 11, 10, 19, 30));

            Showing showing6 = new Showing();
            showing6.setMovie(movie);
            showing6.setCinema(cinema2);
            showing6.setDateTime(LocalDateTime.of(2026, 12, 10, 20, 30));

            showingRepository.save(showing1);
            showingRepository.save(showing2);
            showingRepository.save(showing3);
            showingRepository.save(showing4);
            showingRepository.save(showing5);
            showingRepository.save(showing6);
        }
    }
}