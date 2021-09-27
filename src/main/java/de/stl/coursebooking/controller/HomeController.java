package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.service.AuthService;
import de.stl.coursebooking.service.EmailService;
import de.stl.coursebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
