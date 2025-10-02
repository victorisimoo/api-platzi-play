package com.victorisimo.platzi_play.domain.dto;

import com.victorisimo.platzi_play.domain.Genre;

public record MovieDto(
        Long id,
        String title,
        Integer timeMinutes,
        Genre gender,
        String releaseDate,
        Double rating,
        Boolean status
) {
}
