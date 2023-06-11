package com.example.demo.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Services.CustomerService;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class Customerservice implements CustomerService {
	public Customerservice() {
	}

	@Autowired
	CustomerRepository customerrep;

	public String createuser(int id, String address, String name, String email, String password) {
		Customer c = new Customer();
		c.setCid(id);
		c.setAddress(address);
		c.setCname(name);
		c.setEmail(email);
		c.setPassword(password);
		customerrep.save(c);
		return "Login created";
	}

	public String Auth(String Email, String Password) {
		Optional<Customer> c = customerrep.findAll().stream().filter(x -> x.getEmail().equals(Email)).findAny();
		if (c.isPresent()) {
			Customer ct = c.get();
			if (ct.getPassword().equals(Password)) {
				String s = "Welcome " + ct.getCname();
				return s;
			} else {
				return "Wrong Password";
			}
		} else {
			return "Invalid credentials";
		}
	}
}