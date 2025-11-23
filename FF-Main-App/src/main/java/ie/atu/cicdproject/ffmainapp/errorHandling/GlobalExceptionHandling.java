package ie.atu.cicdproject.ffmainapp.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(NoStationsFoundException.class)
    public ResponseEntity<String> handleNoStations(NoStationsFoundException nsf) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(nsf.getMessage());
    }
}
