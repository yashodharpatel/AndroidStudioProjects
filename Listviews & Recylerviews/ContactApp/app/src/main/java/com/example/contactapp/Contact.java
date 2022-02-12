package com.example.contactapp;

public class Contact {

	private String name;

	private String mobileNo;

	public Contact(String name, String mobileNo) {
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}
}