package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.UserDto;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
/*
 * @author Alissa, Zahra
 *
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/current-user")
    @ResponseBody
    public UserDto currentUser(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }

    @GetMapping("/lecturers")
    @ResponseBody
    public List<UserDto> getLecturers() {
        return userService.getAllLecturer().stream().map(u -> new UserDto(u.getFirstName(), u.getLastName(), u.getEmail(), u.getRole())).collect(Collectors.toList());
    }

    @GetMapping("/account")
    public String accountView() {
        return "accountView";
    }

    @GetMapping("/students")
    @ResponseBody
    public List<UserDto> getAllStudents() {
        return userService.getAllStudents().stream().map(u -> new UserDto(u.getFirstName(), u.getLastName(), u.getEmail(), u.getRole())).collect(Collectors.toList());
    }
}
