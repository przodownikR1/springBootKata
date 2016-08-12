package pl.java.scalatech.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such customer")
@Slf4j
public class CustomerFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomerFoundException(String key) {
          
        super(key + " not available");
        log.info("CustomerFoundException !!!!");
    }
}