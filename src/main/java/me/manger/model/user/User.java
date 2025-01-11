package me.manger.model.user;

import me.manger.model.notification.Notification;

import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private double debt;
    private UserType type;

    private ArrayList<Notification> notifications;

}
