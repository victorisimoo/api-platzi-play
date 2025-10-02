package com.victorisimo.platzi_play.web.exception;

import com.victorisimo.platzi_play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException exception) {
        Error error = new Error("movie-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieModifiedDontExist.class)
    public ResponseEntity<Error> handleException(MovieModifiedDontExist exception) {
        Error error = new Error("movie-does-not-exist", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }


}
