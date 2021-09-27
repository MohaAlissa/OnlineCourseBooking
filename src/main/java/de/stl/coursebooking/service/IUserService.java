package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
/*
 * @author Saeed, Ullah, Alissa
 *
 */
public interface IUserService extends UserDetailsService {
    public void addStudent(UserRegistrationDto userRegistrationDto);
    public void addLecturer(UserRegistrationDto userRegistrationDto);
    public User findUserByEmail(String email);
    public List<User> getAllLecturer();
    public List<User> getAllStudents();
}
