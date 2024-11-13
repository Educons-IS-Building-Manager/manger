package me.manger.model;

import me.manger.model.building.Building;
import me.manger.model.user.User;

import java.util.ArrayList;

public class Company {

	private String name;
	private String email;
	private String phoneNumber;
	private double price;

	private ArrayList<User> admins;
	private ArrayList<Building> buildings;

	public Company() {}

	public Company(String name, String email, String phoneNumber, double price) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.price = price;
		this.admins = new ArrayList<>();
		this.buildings = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<User> getAdmins() {
		return admins;
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

}
