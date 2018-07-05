package com.ab.bean;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

public class CreateCustomerRequest {

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

	public CreateCustomerRequest() {

	}

	public CreateCustomerRequest(String name, int age, String address, double salary) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
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

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
