package pl.java.scalatech.web.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/dateAndTime/")
@Slf4j
public class DateTimeRequestController {
 
    @RequestMapping(value = "dateSimple", method = RequestMethod.POST)
    public void processDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
      log.info("+++ {}",date);  
    }
    
    
    @RequestMapping(value = "dateSimple2", method = RequestMethod.POST)
    public void processDate2(@RequestParam("date")  @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate date) {
        log.info("+++ {}",date);
       
    }
}