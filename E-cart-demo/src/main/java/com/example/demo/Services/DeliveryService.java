package com.example.demo.Services;

public interface DeliveryService {
	public String DeliveryStatus(String productname, int customerid);

	public String UpdateStatus(String productname, int productquantity, int customerid);
}