package me.manger.model;

import me.manger.model.Apartment;
import java.util.ArrayList;

public class Building {

    private String address;
    private double totalMoney;

    private ArrayList<Apartment> apartments;

    public Building(String address, double totalMoney) {
        this.address = address;
        this.totalMoney = totalMoney;
        this.apartments = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }
    
    public void deposit(double amount) {
        totalMoney += amount;
    }
    
    public void withdraw(double amount) {
        totalMoney -= amount;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

}
