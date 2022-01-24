package com.paydala.common.exception;

import com.paydala.common.util.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static Logger LOG = LoggerFactory.getLogger(JwtHelper.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity genericFailure(Exception exception) {
        LOG.error("Global Exception Handler [Generic Failure]: ", exception);
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    public ResponseEntity badRequest(Exception exception) {
        LOG.error("Global Exception Handler [Bad Request]: ", exception);
        return new ResponseEntity<>("There is an issue with the request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity userExists(Exception exception) {
        LOG.error("Global Exception Handler [User Exists]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity unAuthorized(Exception exception) {
        LOG.error("Global Exception Handler [Unauthorized]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity unAuthorizedJwtExpired(Exception exception) {
        LOG.error("Global Exception Handler [Unauthorized]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity notFound(Exception exception) {
        LOG.error("Global Exception Handler [Not Found]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SessionDataException.class)
    public ResponseEntity invalidSessionData(Exception exception) {
        LOG.error("Global Exception Handler [Invalid Session Data]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = JwtException.class)
    public ResponseEntity jwtError(Exception exception) {
        LOG.error("Global Exception Handler [JWT Error]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = PaymentException.class)
    public ResponseEntity transferException(Exception exception) {
        LOG.error("Global Exception Handler [Payment Error]: ", exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
