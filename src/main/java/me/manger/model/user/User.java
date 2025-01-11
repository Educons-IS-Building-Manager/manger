package me.manger.model.user;

import me.manger.model.building.Apartment;
import me.manger.model.Notification;

import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;

    private UserType type;

    private ArrayList<Notification> notifications;
    private ArrayList<Apartment> apartments;

}
