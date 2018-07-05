package com.ab.bean;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

public class GetCustomerDetailsResponse {

	String name;
	int age;
	String address;
	double salary;

	@NotNull
	String email;

	public String getEmail() {
		return email;
	}

	@Required
	public void setEmail(String email) {
		this.email = email;
	}

	@Required
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Required
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setsalary(double salary) {
		this.salary = salary;
	}
}