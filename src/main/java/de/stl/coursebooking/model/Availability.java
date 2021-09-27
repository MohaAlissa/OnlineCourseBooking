package de.stl.coursebooking.model;
/*
 * @author Saeed, Ullah
 *
 */
import de.stl.coursebooking.enums.Weekday;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "availabilities")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lecturer;
    private Weekday weekday;
    private String startsAt;
    private String endsAt;
    @CreationTimestamp
    private Timestamp createdAt;

    public Availability() {}

    public Availability(String lecturer, Weekday weekday, String startsAt, String endsAt) {
        this.lecturer = lecturer;
        this.weekday = weekday;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", lecturer='" + lecturer + '\'' +
                ", weekday=" + weekday +
                ", startsAt=" + startsAt +
                ", endsAt=" + endsAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
