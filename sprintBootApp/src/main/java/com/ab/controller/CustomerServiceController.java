package com.ab.controller;

import com.ab.bean.CreateCustomerResponse;
import com.ab.bean.Customer;
import com.ab.bean.DeleteCustomerRequest;
import com.ab.bean.DeleteCustomerResponse;
import com.ab.bean.GetCustomerDetailsRequest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ab.service.ICustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/customers")
	public List<Customer> findCustomers() {

		return customerService.findAll();
	}

	@RequestMapping("/customer/search")
	public List<Customer> findCustomer(@RequestBody GetCustomerDetailsRequest request) {

		return customerService.findByEmail(request.getEmail());
	}

	@Transactional(rollbackFor = Exception.class)
	@RequestMapping("/customer/create")
	public CreateCustomerResponse insertCustomer(@RequestBody Customer customer) throws Exception {

		try {
			return customerService.create(customer);
		} catch (Exception ex) {
			throw new Exception(ex);
		}

	}

	@RequestMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {

		return customerService.update(customer);
	}

	@RequestMapping("/customer/delete")
	public DeleteCustomerResponse deleteCustomer(@RequestBody DeleteCustomerRequest request) {

		if (request.getEmail() != null) {
			return customerService.deleteCustomerByEmail(request.getEmail());
		}

		return customerService.deleteCustomerByName(request.getName());

	}

}
