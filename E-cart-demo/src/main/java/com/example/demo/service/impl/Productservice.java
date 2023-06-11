package com.example.demo.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class Productservice {
	@Autowired
	ProductRepository productrep;

	public String createproduct(int pid, String pname, int availablility, float price) {
		Product p = new Product();
		p.setPid(pid);
		p.setPname(pname);
		p.setAvailablility(availablility);
		p.setPrice(price);
		productrep.save(p);
		return "Product Sucessfully addded";
	}

	public Optional<Product> ProductCheck(String ProductName) {
		Optional<Product> p = productrep.findAll().stream().filter(x -> x.getPname().equals(ProductName)).findAny();
		if (p.isPresent()) {
			Product pd = p.get();
			return Optional.ofNullable(pd);
		} else {
			return null;
		}
	}
}