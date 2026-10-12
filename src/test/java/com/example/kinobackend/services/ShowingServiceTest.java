package com.example.kinobackend.services;

import com.example.kinobackend.model.Showing;
import com.example.kinobackend.repositories.ShowingRepository;
import com.example.kinobackend.service.ShowingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowingServiceTest {

    @Mock
    ShowingRepository showingRepository;

    @InjectMocks
    ShowingService showingService;

    @Test
    void testGetShowingsByMovieId(){

        Integer movieId=1;
        Showing showing1 = new Showing();
        showing1.setDateTime(LocalDateTime.of(2026,10,11,19,30));

        Showing showing2 = new Showing();
        showing2.setDateTime(LocalDateTime.of(2026,10,10,20,30));

        when(showingRepository.findByMovieMovieId(movieId))
                .thenReturn(List.of(showing1,showing2));

        List<Showing>showings = showingService.getShowingByMovieId(movieId);

        assertEquals(2,showings.size());
        assertEquals(LocalDateTime.of(2026,10,11,19,30),showings.get(0).getDateTime());

        verify(showingRepository).findByMovieMovieId(movieId);
    }

    @Test
    void deleteShowing(){
        Integer showingId=1;

        showingService.deleteShowing(showingId);

        verify(showingRepository).deleteById(showingId);
    }
}
