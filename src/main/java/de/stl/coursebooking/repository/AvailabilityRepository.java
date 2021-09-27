package de.stl.coursebooking.repository;

import de.stl.coursebooking.enums.Weekday;
import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
/*
 * @author Saeed, Ullah
 *
 */
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    @Query("SELECT u FROM Availability u WHERE u.lecturer = ?1")
    public List<Availability> findByLecturer(String email);

    public Availability findAvailabilityByLecturerAndWeekdayAndEndsAtAndStartsAt(String lecturer, Weekday weekday, String endsAt, String startsAt);

    @Query(value = "SELECT * FROM availabilities", nativeQuery = true)
    public List<Availability> findAll();

    @Transactional
    @Modifying
    public void deleteAvailabilityById(Long id);

}
