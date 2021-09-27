package de.stl.coursebooking.dto;

import java.util.Date;
import java.util.List;
/*
 * @author Alissa, Zahra
 *
 */
public class AppointmentDto {
    private String student;
    private String lecturer;
    private List<String> participants;
    private String description;
    private Date startsAt;
    private Date endsAt;

    public AppointmentDto() {}

    public AppointmentDto(String student, String lecturer, List<String> participants, String description, Date startsAt, Date endsAt) {
        this.student = student;
        this.lecturer = lecturer;
        this.participants = participants;
        this.description = description;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    @Override
    public String toString() {
        return "AppointmentDto{" +
                "student='" + student + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", participants=" + participants +
                ", description='" + description + '\'' +
                ", startsAt=" + startsAt +
                ", endsAt=" + endsAt +
                '}';
    }
}
