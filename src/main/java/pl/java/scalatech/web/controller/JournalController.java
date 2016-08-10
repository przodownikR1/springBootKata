package pl.java.scalatech.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.java.scalatech.domain.Journal;
import pl.java.scalatech.repository.JournalRepository;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
@Controller
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalRepository journalRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", journalRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/api", produces = {APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournla() {
        return journalRepository.findAll();
    }
}