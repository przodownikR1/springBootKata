package pl.java.scalatech.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
public class CustomerProblem extends RuntimeException{

    public CustomerProblem() {
        super();      
    }

    public CustomerProblem(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerProblem(String message) {
        super(message);
    }

    public CustomerProblem(Throwable cause) {
        super(cause);
    }

}
