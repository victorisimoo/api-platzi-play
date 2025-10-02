package com.victorisimo.platzi_play.domain.dto;

import com.victorisimo.platzi_play.domain.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "Title is mandatory")
        String title,

        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,

        @Min(message = "Rating must be at least 0.0", value = 0)
        @Max(message = "Rating must be at most 5.0", value = 5)
        Double rating
) {
}
