package com.victorisimo.platzi_play.domain.dto;

import com.victorisimo.platzi_play.domain.Genre;

public record UpdateMovieDto(
        String title,
        String releaseDate,
        Double rating
) {
}
