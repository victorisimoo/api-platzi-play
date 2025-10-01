package com.victorisimo.platzi_play.web.controller;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.domain.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// MovieController class to handle movie-related HTTP requests
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Method to get all movies
    @GetMapping("/movies")
    public List<MovieDto> getAll(){
        return this.movieService.getAll();
    }
}
