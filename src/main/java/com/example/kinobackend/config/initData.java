package com.example.kinobackend.config;

import com.example.kinobackend.model.Movie;
import com.example.kinobackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run (String... args){
        if (movieRepository.count()==0){
            Movie movie1 = new Movie();
            movie1.setName("Dalans dadler");
            movie1.setGenre("Erotik");
            movie1.setDescription("Dalan bruger hans sidste penge på dadler efter han tabte dem alle ved at gamble. Men tilsyndeladende er der mere til disse dadler en som lige møder øjet");
            movie1.setAgeLimit(18);

            Movie movie2 = new Movie();
            movie2.setName("Interstellar");
            movie2.setGenre("Science-Fiction");
            movie2.setAgeLimit(15);
            movie2.setDescription("Man der tager til rum for mission for at redde verden: EELLLLLLER!!!?");

            movieRepository.save(movie1);
            movieRepository.save(movie2);
        }
    }
}
