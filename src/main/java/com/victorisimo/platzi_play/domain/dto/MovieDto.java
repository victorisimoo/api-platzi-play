package com.victorisimo.platzi_play.domain.dto;

import com.victorisimo.platzi_play.domain.Genre;
import jakarta.validation.constraints.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        @NotBlank(message = "Title is mandatory")
        String title,

        @Min(message = "Time in minutes must be at least 1", value = 1)
        @Max(message = "Time in minutes must be at most 500", value = 500)
        Integer timeMinutes,

        @NotNull (message = "Genre is mandatory")
        Genre gender,

        @NotNull (message = "Release date is mandatory")
        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,

        @NotNull (message = "Rating is mandatory")
        @Min(message = "Rating must be at least 0.0", value = 0)
        @Max(message = "Rating must be at most 5.0", value = 5)
        Double rating,

        @NotNull (message = "Status is mandatory")
        Boolean status
) {
}
