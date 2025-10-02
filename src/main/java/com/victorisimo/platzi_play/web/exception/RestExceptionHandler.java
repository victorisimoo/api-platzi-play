package com.victorisimo.platzi_play.web.exception;

import com.victorisimo.platzi_play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    // Handle case when movie to be created already exists
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException exception) {
        Error error = new Error("movie-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    // Handle case when movie to be modified does not exist
    @ExceptionHandler(MovieModifiedDontExist.class)
    public ResponseEntity<Error> handleException(MovieModifiedDontExist exception) {
        Error error = new Error("movie-does-not-exist", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException err) {
        List<Error> errors = new ArrayList<>();
        err.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    // Handle all other exceptions
    public ResponseEntity<Error> handleException(Exception exception) {
        Error error = new Error("internal-server-error", exception.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }


}
