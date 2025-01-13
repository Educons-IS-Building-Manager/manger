package me.manger.model;

import java.util.ArrayList;
import me.manger.model.user.Owner;

public class Apartment {

    private int number;
    private double area;
    private double balance;

    private ArrayList<Owner> owners;

    public Apartment(int number, double area, double balance) {
        this.number = number;
        this.area = area;
        this.balance = balance;
        this.owners = new ArrayList<>();
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

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
    
    

}
