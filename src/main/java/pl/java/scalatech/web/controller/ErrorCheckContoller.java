package pl.java.scalatech.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.web.controller.exception.CustomerException;
import pl.java.scalatech.web.controller.exception.CustomerProblem;

@RestController
@RequestMapping("/errorCheck")
@Slf4j
public class ErrorCheckContoller {

    @GetMapping("/{errorStatus}")
    public String myError(@PathVariable int errorStatus) throws Exception {
        log.info("errorCheckController :  {}",errorStatus);
      if (errorStatus ==1) {
          log.info("++++ 1");
          throw new CustomerException();
      }else if (errorStatus == 2) {
          log.info("++++ 2");
          throw new CustomerProblem();          
      }else if(errorStatus== 3) {
          log.info("++++ 3");
          throw new FileNotFoundException("File not found.");
      }else if (errorStatus == 4) {
          log.info("++++ 4");
          throw new IOException("Found IO Exception");
      }
      else if (errorStatus == 5) {
          throw new NullPointerException();
      }
    return "ok";
    }
      
    @ExceptionHandler({ CustomerProblem.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleException(NotFoundException e, HttpServletRequest request) {
        log.info(" status : {}, uri : {}  , message : {}",HttpStatus.NOT_FOUND.value(),request.getRequestURI(),e.getMessage());        
        return "myException : " + e.getMessage();
    }
    
}
