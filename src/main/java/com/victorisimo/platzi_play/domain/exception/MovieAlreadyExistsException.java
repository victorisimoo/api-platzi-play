package com.victorisimo.platzi_play.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String title) {
        super("The movie with title '" + title + "' already exists.");
    }


}
