package pl.java.scalatech.web.controller.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    long id;

    public NotFoundException(String message, Throwable cause,long id) {
        super(message, cause);
        this.id = id;

    }

    public NotFoundException(String message, long id) {
        super(message);
        this.id = id;
    }

    public NotFoundException(Throwable cause) {
        super(cause);
        this.id = id;
    }
    
    

}
