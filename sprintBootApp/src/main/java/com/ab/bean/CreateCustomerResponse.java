package com.ab.bean;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

public class CreateCustomerResponse {

	String name;
	int age;
	String address;
	double salary;
	String timeStamp = "today";

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@NotNull
	String email;

	public String getEmail() {
		return email;
	}

	@Required
	public void setEmail(String email) {
		this.email = email;
	}

	public CreateCustomerResponse() {

	}

	public CreateCustomerResponse(String name, int age, String address, double salary) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}

	@Required
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	@Required
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public double getsalary() {
		return salary;
	}

	public void setsalary(double salary) {
		this.salary = salary;
	}

}
