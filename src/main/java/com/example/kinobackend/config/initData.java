package com.example.kinobackend.config;

import com.example.kinobackend.model.Customer;
import com.example.kinobackend.model.Movie;
import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.CustomerRepository;
import com.example.kinobackend.repositories.MovieRepository;
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
    ShowingRepository showingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) {

        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer();
            customer1.setName("Deniz Dalan");
            customer1.setEmail("deniz@example.com");
            customer1.setPhone("12345678");

            customerRepository.save(customer1);
        }

        if (movieRepository.count() == 0) {

            Movie movie1 = new Movie();
            movie1.setName("Dalans dadler");
            movie1.setGenre("Erotik");
            movie1.setDescription("...");
            movie1.setAgeLimit(18);

            movieRepository.save(movie1);

            Movie movie2 = new Movie();
            movie2.setName("Interstellar");
            movie2.setGenre("Science-Fiction");
            movie2.setAgeLimit(15);
            movie2.setDescription("...");

            movieRepository.save(movie2);
        }

        if (showingRepository.count() == 0) {

            Movie movie1 = movieRepository.findAll().get(0);

            Showing showing1 = new Showing();
            showing1.setMovie(movie1);
            showing1.setDateTime(LocalDateTime.of(2026, 10, 10, 18, 30));

            Showing showing2 = new Showing();
            showing2.setMovie(movie1);
            showing2.setDateTime(LocalDateTime.of(2026, 10, 10, 19, 30));

            Showing showing3 = new Showing();
            showing3.setMovie(movie1);
            showing3.setDateTime(LocalDateTime.of(2026, 10, 10, 20, 30));

            Showing showing4 = new Showing();
            showing4.setMovie(movie1);
            showing4.setDateTime(LocalDateTime.of(2026, 11, 10, 18, 30));

            Showing showing5 = new Showing();
            showing5.setMovie(movie1);
            showing5.setDateTime(LocalDateTime.of(2026, 11, 10, 19, 30));

            Showing showing6 = new Showing();
            showing6.setMovie(movie1);
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