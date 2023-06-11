package com.example.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Product;
import com.example.demo.service.impl.Customerservice;
import com.example.demo.service.impl.Deliveryservice;
import com.example.demo.service.impl.Productservice;

@RestController
public class Controller {
	@Autowired
	Customerservice cService;
	@Autowired
	Productservice pService;
	@Autowired
	Deliveryservice dService;

	@PutMapping("/createuser")
	@ResponseBody
	public String createUser(@RequestBody Customer c) {
		return cService.createuser(c.getCid(), c.getAddress(), c.getCname(), c.getEmail(), c.getPassword());
	}

	@PostMapping("/auth")
	@ResponseBody
	public String auth(@RequestBody Customer c) {
		return cService.Auth(c.getEmail(), c.getPassword());
	}

	@PutMapping("/createproduct")
	@ResponseBody
	public String createProduct(@RequestBody Product p) {
		return pService.createproduct(p.getPid(), p.getPname(), p.getAvailablility(), p.getPrice());
	}

	@PostMapping("/getproduct")
//@ResponseBody
	public Optional<Product> productCheck(@RequestBody Product p) {
		return pService.ProductCheck(p.getPname());
	}

	@PutMapping("/dispatch")
	public String dispatchStatus(@RequestBody Delivery d) {
		return dService.DispatchStatus(d.getPname(), d.getProductquantity(), d.getCid());
	}

	@PutMapping("/deliverystatus")
	public String updatestatus(@RequestBody Delivery d) {
		return dService.UpdateStatus(d.getPname(), d.getCid());
	}
}