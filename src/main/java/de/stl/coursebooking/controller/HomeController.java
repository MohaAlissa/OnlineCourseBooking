package de.stl.coursebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.stl.coursebooking.service.EmailService;
/*
 * @author Alissa, Zahra
 *
 */
@Controller
public class HomeController {

    @Autowired
    EmailService emailService;

    @GetMapping({"/", "/home"})
    public String home(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return "index";
    }

    @GetMapping("/error")
    public String error() { return "error"; }

}
