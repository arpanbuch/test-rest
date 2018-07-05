package com.ab.service;

import java.util.List;

import com.ab.bean.CreateCustomerResponse;
import com.ab.bean.Customer;
import com.ab.bean.DeleteCustomerResponse;
import com.ab.bean.GetCustomerDetailsResponse;

public interface ICustomerService {

	public List<Customer> findAll();

	public List<Customer> findByEmail(String email);

	public CreateCustomerResponse create(Customer customer);

	public Customer update(Customer customer);

	public DeleteCustomerResponse deleteCustomerByName(String name);

	public DeleteCustomerResponse deleteCustomerByEmail(String email);
}
