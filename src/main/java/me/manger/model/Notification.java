package me.manger.model;

import java.util.Date;

public class Notification {

    private Date date;
    private String message;

    public Notification(String message) {
        date = new Date();
        this.message = message;
    }

    public Notification(long date, String message) {
        this.date = new Date(date);
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

}
