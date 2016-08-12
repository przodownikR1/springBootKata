package pl.java.scalatech.web.controller.exception;

import lombok.Data;

@Data
public class CustomerException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    private int status;
    
    private String message;

    public CustomerException() {
        super();
    }

    public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(Throwable cause) {
        super(cause);   
    }

    public CustomerException(int value, String message) {
         this.status= value;
         this.message = message;
    }
    

}
