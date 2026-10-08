package com.example.kinobackend.services;

import com.example.kinobackend.model.Movie;
import com.example.kinobackend.repositories.MovieRepository;
import com.example.kinobackend.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

    @Test
    void testGetAllMovies(){

        Movie movie1 = new Movie();
        movie1.setName("Interstellar");

        Movie movie2 = new Movie();
        movie2.setName("The Dark Knight");

    when(movieRepository.findAll())
            .thenReturn(List.of(movie1, movie2));

        List<Movie> movies = movieService.getAllMovies();

        assertEquals(2, movies.size());
        assertEquals("Interstellar", movies.get(0).getName());
        assertEquals("The Dark Knight", movies.get(1).getName());
    }


    @Test
    void testCreateMovie(){
        Movie movie = new Movie();
        movie.setName("Interstellar2");
        movie.setGenre("Fiction");
        movie.setAgeLimit(12);

        when (movieRepository.save(movie)).thenReturn(movie);

        Movie savedMovie = movieService.createMovie(movie);

        assertEquals("Interstellar2", savedMovie.getName());
        assertEquals("Fiction", savedMovie.getGenre());
        assertEquals(12, savedMovie.getAgeLimit());

        verify(movieRepository).save(movie);
    }
}
