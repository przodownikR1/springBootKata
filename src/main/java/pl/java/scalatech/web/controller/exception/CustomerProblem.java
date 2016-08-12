package pl.java.scalatech.web.controller.exception;

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
