package com.victorisimo.platzi_play.domain.dto;

public record MovieDto(
        String title,
        Integer timeMinutes,
        String gender,
        String releaseDate,
        Double rating,
        String status
) {
}
