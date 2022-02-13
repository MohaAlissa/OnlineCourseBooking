package de.stl.coursebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.service.IUserService;
/*
 * @author Alissa, Zahra
 *
 */
@Controller
public class AuthController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String postRegister(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.addStudent(userRegistrationDto);
        return "successfulRegistration";
    }

    @PostMapping("/register-lecturer")
    @ResponseBody
    public String registerLecturer(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.addLecturer(userRegistrationDto);
        return "successfulRegistration";
    }

    @GetMapping("/success-registration")
    public String successfulRegistration() {
        return "successfulRegistration";
    }
}
