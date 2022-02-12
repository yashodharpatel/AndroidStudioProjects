package com.example.sqlitedb;

public class Employee {
	int emp_id;
	String name;
	double increment;

	public Employee(int emp_id, String name, double increment) {
		this.emp_id = emp_id;
		this.name = name;
		this.increment = increment;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public String getName() {
		return name;
	}

	public double getIncrement() {
		return increment;
	}
}