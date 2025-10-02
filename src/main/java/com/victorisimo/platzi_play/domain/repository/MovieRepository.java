package com.victorisimo.platzi_play.domain.repository;

import com.victorisimo.platzi_play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
}
