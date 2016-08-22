package pl.java.scalatech.web.controller.errorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
public class ErrorInfo {

    private String url;
    
    private String message;
    
}
