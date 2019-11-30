package pl.put.poznan.buildings.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class that handles exceptions for buildings controller.
 */
@ControllerAdvice
public class LocationNotFoundAdvice {

    /**
     * Handler for LocationNotFoundException.
     * Returns exception message in response body with 400 bad request error code.
     * @param ex Exception to handle
     * @return Exception message
     */
    @ResponseBody
    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String locationNotFoundHandler(LocationNotFoundException ex) {
        return ex.getMessage();
    }
}
