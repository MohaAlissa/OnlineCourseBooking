package de.stl.coursebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.stl.coursebooking.model.User;
/*
 * @author Ajini, Alghazi
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    public List<User> findByRole(String role);
}
