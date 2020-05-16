package com.cognixia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.model.Account;
import com.cognixia.model.Customer;
import com.cognixia.repository.CustomerRepository;
import com.cognixia.service.AccountService;



@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountService accountService;

	@PostMapping(value = "/customer")
	public Customer save(@RequestBody Customer customer) {
		List<Account> accounts = customer.getAccount();
		for (Account account : accounts) {
			accountService.update(account);
		}
		Customer result = customerRepository.save(customer);
		result.setAccount(accountService.findByCutomer(result.getCustomerId()));
		return result;
	}

	@GetMapping(value = "/customer")
	public Iterable<Customer> all() {

		List<Customer> customers = customerRepository.findAll();

		for (Customer c : customers) {
			c.setAccount(accountService.findByCutomer(c.getCustomerId()));
		}
		return customers;
	}

	@GetMapping(value = "/customer/{customerId}")
	public Customer findByAccountId(@PathVariable Integer customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		customer.setAccount(accountService.findByCutomer(customerId));
		return customer;
	}

	@PutMapping(value = "/customer")
	public Customer update(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@DeleteMapping(value = "/customer")
	public void delete(@RequestBody Customer customer) {
		customerRepository.delete(customer);
	}

}