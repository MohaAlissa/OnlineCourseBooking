package de.stl.coursebooking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.dto.CancelAppointmentDto;
import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.service.IAppointmentService;
/*
 * @author Alissa, Zahra
 *
 */
@Controller
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping("/appointments")
    public String viewAppointments() throws IOException {
        return "appointments";
    }

    @GetMapping("/create-appointment")
    public String createAppointmentView() {
        return "createAppointment";
    }

    @PostMapping("/appointments")
    @ResponseBody
    public void bookAppointment(@RequestBody AppointmentDto appointmentDto) throws IOException {
        appointmentService.createAppointment(appointmentDto);
    }

    @GetMapping("/api/appointments/student/{student}")
    @ResponseBody
    public List<Appointment> findAppointmentByStudent(@PathVariable("student") String student) {
        return appointmentService.findAppointmentsByStudent(student);
    }

    @GetMapping("/api/appointments/lecturer/{lecturer}")
    @ResponseBody
    public List<Appointment> findAppointmentByLecturer(@PathVariable("lecturer") String lecturer) {
        return appointmentService.findAppointmentsByLecturer(lecturer);
    }

    @PatchMapping("/api/appointments/confirm/{id}")
    @ResponseBody
    public void confirmAppointment(@PathVariable("id") String id) throws IOException {
        appointmentService.confirmAppointment(Long.parseLong(id));
    }

    @PatchMapping("/api/appointments/cancel/{id}")
    @ResponseBody
    public void cancelAppointment(@PathVariable("id") String id,  @RequestBody CancelAppointmentDto cancelAppointmentDto) throws IOException {
        appointmentService.cancelAppointment(Long.parseLong(id), cancelAppointmentDto.getReason(), cancelAppointmentDto.getCancelledBy());
    }
}
