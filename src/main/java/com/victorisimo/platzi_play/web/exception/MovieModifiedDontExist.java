package com.victorisimo.platzi_play.web.exception;

public class MovieModifiedDontExist extends RuntimeException {

    public MovieModifiedDontExist(Long id) {
        super("The movie with id '" + id + "' does not exist and cannot be modified.");
    }
}
