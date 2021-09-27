package de.stl.coursebooking.dto;
/*
 * @author Alissa, Zahra
 *
 */
public class CancelAppointmentDto {
    private String reason;
    private String cancelledBy;

    public CancelAppointmentDto() {};

    public CancelAppointmentDto(String reason, String cancelledBy) {
        this.reason = reason;
        this.cancelledBy = cancelledBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }
}
