package pl.java.scalatech.web.controller.errorHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.web.controller.exception.CustomerException;
import pl.java.scalatech.web.controller.exception.DuplicateException;

@ControllerAdvice//(basePackageClasses = CustomerController.class)
@Slf4j
public class CustomerControllerAdvice {//implements ErrorController{
    
    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.info("customerContollerAdvice -----------");
        return new ResponseEntity(new CustomerException(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }

    
    @RequestMapping(path = "/error")
    public HttpEntity<?> handleError() {
        log.info("++++++   /error");
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException npe) {
        log.info("null pointer exception resolver !!!!");
        return new ResponseEntity<>("null poiner exception", HttpStatus.INTERNAL_SERVER_ERROR);
    }

  
    
    @ExceptionHandler(value=IllegalArgumentException.class)
    public String illegalArgs(Model model,IllegalArgumentException iea){
        model.addAttribute("error",new Error(iea.getMessage()));
        log.info("++++ {}",model);
         return "errors";
    }
}