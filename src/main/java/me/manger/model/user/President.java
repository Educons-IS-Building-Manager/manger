package me.manger.model.user;

import me.manger.model.Notification;

import java.util.ArrayList;

public class President {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;

    private ArrayList<Notification> notifications;

    public President(String firstName, String lastName, String email, String phone, String username, String password,
                 ArrayList<Notification> notifications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.notifications = notifications;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
