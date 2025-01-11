package me.manger.model.ledger;

import java.util.Date;

public class Entry {

    private Date date;
    private String message;

    public Entry(String message) {
        date = new Date();
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

}
