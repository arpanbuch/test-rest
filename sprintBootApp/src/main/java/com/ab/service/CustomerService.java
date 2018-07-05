package com.ab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ab.bean.CreateCustomerResponse;
import com.ab.bean.Customer;
import com.ab.bean.DeleteCustomerResponse;
import com.commons.util;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private JdbcTemplate jtm;

	@Override
	public List<Customer> findAll() {

		String sql = "select * from CUSTOMERS";

		List<Customer> customers = jtm.query(sql, new BeanPropertyRowMapper(Customer.class));

		return customers;
	}

	@Override
	public List<Customer> findByEmail(String email) {
		String sql = "select * from CUSTOMERS where lower(email)='" + email.toLowerCase() + "'";

		List<Customer> customers = jtm.query(sql, new BeanPropertyRowMapper(Customer.class));

		return customers;
	}

	@Override
	public CreateCustomerResponse create(Customer customer) {

		int numOfRowsAffected = 0;
		CreateCustomerResponse response = new CreateCustomerResponse();

		numOfRowsAffected = jtm.update(
				"insert into CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY, EMAIL) " + "values(?, ?,  ?, ?, ?, ? )",
				new Object[] { util.getRandomId(), customer.getName(), customer.getAge(), customer.getAddress(),
						customer.getSalary(), customer.getEmail() });

		if (numOfRowsAffected == 1) {
			return response;
		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {

		int numOfRowsAffected = 0;

		String sql = "UPDATE CUSTOMERS SET (NAME, AGE, ADDRESS, SALARY) =('" + customer.getName() + "','"
				+ customer.getAge() + "','" + customer.getAddress() + "','" + customer.getSalary() + "') WHERE EMAIL ='"
				+ customer.getEmail() + "'";

		numOfRowsAffected = jtm.update(sql);

		if (numOfRowsAffected == 1) {
			return customer;
		}
		return null;
	}

	@Override
	public DeleteCustomerResponse deleteCustomerByName(String name) {
		String sql = "Delete from CUSTOMERS where lower(name)='" + name.toLowerCase() + "'";

		DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();

		int numberOfDeltedRows = jtm.update(sql);

		deleteCustomerResponse.setNumberOfDeletedRecords(numberOfDeltedRows);

		return deleteCustomerResponse;

	}

	@Override
	public DeleteCustomerResponse deleteCustomerByEmail(String email) {
		String sql = "Delete from CUSTOMERS where lower(email)='" + email.toLowerCase() + "'";

		DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();

		int numberOfDeltedRows = jtm.update(sql);

		deleteCustomerResponse.setNumberOfDeletedRecords(numberOfDeltedRows);

		return deleteCustomerResponse;

	}

}
