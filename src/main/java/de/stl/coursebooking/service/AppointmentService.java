package de.stl.coursebooking.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.repository.AppointmentRepository;
/*
 * @author Ajini, Alghazi, Al_Mahamed
 *
 */
@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public void createAppointment(AppointmentDto appointmentDto) throws IOException {
        Appointment appointment = new Appointment(
                appointmentDto.getStudent(),
                appointmentDto.getLecturer(),
                appointmentDto.getParticipants(),
                appointmentDto.getDescription(),
                new Timestamp(appointmentDto.getStartsAt().getTime()),
                new Timestamp(appointmentDto.getEndsAt().getTime())
        );
        appointmentRepository.save(appointment);
        emailService.sendAppointmentEmail(appointment, "APT - New Appointment Booked", "A new appointment is booked and needs to be confirmed");
    }

    @Override
    public List<Appointment> findAppointmentsByStudent(String student) {
        return appointmentRepository.findAppointmentsByStudent(student);
    }

    @Override
    public List<Appointment> findAppointmentsByLecturer(String lecturer) {
        return appointmentRepository.findAppointmentsByLecturer(lecturer);
    }

    @Override
    public void confirmAppointment(Long id) throws IOException {
        appointmentRepository.confirmAppointment(id);
        Appointment appointment = appointmentRepository.findAppointmentsById(id);
        emailService.sendAppointmentEmail(appointment, "APT - Appointment was confirmed", "The lecturer confirmed the below appointment");
    }

    @Override
    public void cancelAppointment(Long id, String reason, String cancelledBy) throws IOException {
        appointmentRepository.cancelAppointment(id, reason);
        Appointment appointment = appointmentRepository.findAppointmentsById(id);
        emailService.sendAppointmentEmail(appointment, "APT - Appointment was cancelled", "The appointment was cancelled by " + cancelledBy + ", reason: " + reason);
    }
}
