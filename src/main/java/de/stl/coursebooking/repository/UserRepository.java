package de.stl.coursebooking.repository;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/*
 * @author Saeed, Ullah
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    public List<User> findByRole(String role);
}
