package com.victorisimo.platzi_play.web.controller;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.domain.dto.SuggestRequestDto;
import com.victorisimo.platzi_play.domain.dto.UpdateMovieDto;
import com.victorisimo.platzi_play.domain.service.MovieService;
import com.victorisimo.platzi_play.domain.service.PlatziPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// MovieController class to handle movie-related HTTP requests
@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movie management endpoints")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;

    public MovieController(MovieService movieService, PlatziPlayAiService platziPlayAiService) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;
    }

    // Method to get all movies
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> response = this.movieService.getAll();
        if(response.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }

    // Method to get a movie by its ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Get movie by ID",
            description = "Retrieve a movie by its unique ID",
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Movie found"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Movie not found",
                            content = @Content())
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Id for search movie", example = "9") @PathVariable long id) {
        MovieDto response = this.movieService.getById(id);
        if(response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method to add a new movie
    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movieDto));
    }

    // Method to update an existing movie
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    // Method to delete a movie by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        if(this.movieService.delete(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/suggestions")
    public ResponseEntity<String> generateMoviesSuggestions(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok().body(platziPlayAiService.generateMoviesSuggestions(suggestRequestDto.userPreferences()));
    }
}
