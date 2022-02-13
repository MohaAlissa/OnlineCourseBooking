package de.stl.coursebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.CustomUserDetails;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.repository.UserRepository;
import de.stl.coursebooking.util.Role;
/*
 * @author Ajini, Alghazi, Al_Mahamed
 *
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void addStudent(UserRegistrationDto userRegistrationDto) {
        String encryptedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        User newUser = new User(userRegistrationDto.getEmail(), encryptedPassword, userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(), Role.STUDENT);
        try {
            userRepo.save(newUser);
        } catch(DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User exists already");
        }
    }

    @Override
    public void addLecturer(UserRegistrationDto userRegistrationDto) {
        String encryptedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        User newUser = new User(userRegistrationDto.getEmail(), encryptedPassword, userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(), Role.LECTURER);
        try {
            userRepo.save(newUser);
        } catch(DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User exists already");
        }
    }

    public User findUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllLecturer() {
        return userRepo.findByRole(Role.LECTURER);
    }

    @Override
    public List<User> getAllStudents() { return userRepo.findByRole(Role.STUDENT); }
}
