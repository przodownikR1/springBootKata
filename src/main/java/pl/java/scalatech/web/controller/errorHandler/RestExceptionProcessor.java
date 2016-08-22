package pl.java.scalatech.web.controller.errorHandler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.web.controller.exception.NotFoundException;

@ControllerAdvice
@Slf4j
public class RestExceptionProcessor {
     
    @Autowired
    private MessageSource messageSource;
     
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo smartphoneNotFound(HttpServletRequest req, NotFoundException ex) {
        log.info("restExceptionProcessor : advice");
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage("error.no.id", null, locale);
         
        errorMessage += ex.getId();
        String errorURL = req.getRequestURL().toString();
         
        return new ErrorInfo(errorURL, errorMessage);
    }
 
}