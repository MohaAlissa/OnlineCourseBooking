package de.stl.coursebooking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.stl.coursebooking.model.Appointment;
/*
 * @author Ajini, Alghazi
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    public List<Appointment> findAppointmentsByStudent(String student);
    public List<Appointment> findAppointmentsByLecturer(String lecturer);
    public Appointment findAppointmentsById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointments set confirmed = true where id = :id", nativeQuery = true)
    public void confirmAppointment(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointments set cancellation_reason = :reason, cancelled = true where id = :id", nativeQuery = true)
    public void cancelAppointment(@Param("id") Long id, @Param("reason") String reason);
}
