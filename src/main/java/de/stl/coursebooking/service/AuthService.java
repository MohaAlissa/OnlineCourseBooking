package de.stl.coursebooking.service;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
/*
 * @author Ajini, Alghazi, Al_Mahamed
 *
 */
@ManagedBean
@ViewScoped
public class AuthService implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String register() {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);
        System.out.println(repeatPassword);
        return "successfulRegistration";
    }
}
