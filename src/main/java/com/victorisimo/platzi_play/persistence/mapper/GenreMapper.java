package com.victorisimo.platzi_play.persistence.mapper;

import com.victorisimo.platzi_play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genre) {
        if(genre == null) return null;
        return switch (genre.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATED;
            case "TERROR" -> Genre.HORROR;
            case "SCI_FI", "SCI-FI", "SCIFI", "CIENCIA_FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if(genre == null) return null;
        return switch (genre) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "SCI_FI";
            default -> null;
        };
    }



}
