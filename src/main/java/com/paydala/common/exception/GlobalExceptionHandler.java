package com.paydala.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity genericFailure(Exception exception) {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    public ResponseEntity badRequest(Exception exception) {
        return new ResponseEntity<>("There is an issue with the request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity userExists(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity unAuthorized(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity notFound(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
