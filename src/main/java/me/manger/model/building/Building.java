package me.manger.model.building;

import java.util.ArrayList;
import me.manger.model.user.User;

public class Building {

    private String address;
    private double totalMoney;

    private User president;
    private ArrayList<Apartment> apartments;

    public Building(String address, double totalMoney, User president, ArrayList<Apartment> apartments) {
        this.address = address;
        this.totalMoney = totalMoney;
        this.president = president;
        this.apartments = apartments;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public User getPresident() {
        return president;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setPresident(User president) {
        this.president = president;
    }

}
