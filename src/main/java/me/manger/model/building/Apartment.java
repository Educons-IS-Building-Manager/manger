package me.manger.model.building;

import java.util.ArrayList;
import me.manger.model.user.User;

public class Apartment {

    private int number;
    private double area;
    private double balance;

    private ArrayList<User> owners;

    public Apartment(int number, double area, double balance, ArrayList<User> owners) {
        this.number = number;
        this.area = area;
        this.balance = balance;
        this.owners = owners;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<User> getOwners() {
        return owners;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
