package com.victorisimo.platzi_play.domain.service;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.domain.dto.UpdateMovieDto;
import com.victorisimo.platzi_play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto save(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto movieDto) {
        return this.movieRepository.update(id, movieDto);
    }

    public Boolean delete(long id) {
        return this.movieRepository.delete(id);
    }

}
