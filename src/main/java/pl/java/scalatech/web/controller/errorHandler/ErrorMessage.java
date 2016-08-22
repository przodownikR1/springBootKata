package pl.java.scalatech.web.controller.errorHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    @Getter
    @Setter
    private List<String> errors;
    

    public ErrorMessage(String error) {
        this(Collections.singletonList(error));
    }

    public ErrorMessage(String ... errors) {
        this(Arrays.asList(errors));
    }

    
}