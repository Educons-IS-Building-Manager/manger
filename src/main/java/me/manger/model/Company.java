package me.manger.model;

public class Company {

	private String name;
	private String email;
	private String phoneNumber;
	private double price;

	public Company(String name, String email, String phoneNumber, double price) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getPrice() {
		return price;
	}

}
