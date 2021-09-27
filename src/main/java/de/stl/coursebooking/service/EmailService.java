package de.stl.coursebooking.service;

import com.sendgrid.*;
import de.stl.coursebooking.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
/*
 * @author Saeed, Ullah, Alissa
 *
 */
@Service
public class EmailService {

    @Value("${spring.sendgrid.api-key}")
    private String sendgridApiKey;

    @Value("${spring.sendgrid.email}")
    private String fromEmail;

    public void sendAppointmentEmail(Appointment appointment, String subject, String bodyTitle) throws IOException {
        Email from = new Email(fromEmail);
        Email to = new Email(appointment.getLecturer());

        String body = composeBody(appointment, bodyTitle);

        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        Personalization personalization = new Personalization();
        personalization.addTo(to);
        for (String email : appointment.getParticipants()) {
            personalization.addCc(new Email(email));
        }

        mail.addPersonalization(personalization);

        SendGrid sg = new SendGrid(sendgridApiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }

    private String composeBody(Appointment appointment, String title) {
        String s = title + "\n\n";
        s += "Created by " + appointment.getStudent() + "\n";
        s += "Lecturer: " + appointment.getLecturer() + "\n";
        s += "Participants: " + appointment.getParticipants()  + "\n\n";
        s += "Starts at: " + appointment.getStartsAt().toString() + "\n\n";
        s += "Ends at: " + appointment.getEndsAt().toString() + "\n\n";
        s += "Description: " + appointment.getDescription() + "\n";

        return s;
    }
}
