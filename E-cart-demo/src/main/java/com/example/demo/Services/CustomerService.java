package com.example.demo.Services;

public interface CustomerService {
	String createuser(int id, String address, String name, String email, String password);

	String Auth(String Email, String Password);
}