package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Services.DeliveryService;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Product;
import com.example.demo.repository.DeliveryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class Deliveryservice implements DeliveryService {
	@Autowired
	DeliveryRepository deliveryrep;
	@Autowired
	ProductRepository productrep;

	public String UpdateStatus(String productname, int customerid) {
		Optional<Delivery> d = deliveryrep.findAll().stream().filter(x -> x.getCid() == customerid).findAny();
		if (d.isPresent()) {
			Delivery dr = d.get();
			if (dr.getPname().equals(productname)) {
				dr.setDelivery_status("DELIVERED");
				deliveryrep.save(dr);
				return "Delivered";
			} else
				return "product not found";
		} else
			return "customer not found";
	}

	public String DispatchStatus(String productname, int productquantity, int customerid) {
		Optional<Product> p = productrep.findAll().stream().filter(x -> x.getPname().equals(productname)).findAny();
		if (p.isPresent()) {
			Product pr = p.get();
			if (productquantity <= pr.getAvailablility()) {
				Delivery d = new Delivery();
				d.setCid(customerid);
				d.setPid(pr.getPid());
				d.setPname(productname);
				d.setProductquantity(productquantity);
				d.setDelivery_status("TO BE DISPATCHED");
				d.setTotalprice(pr.getPrice() * productquantity);
				pr.setAvailablility(pr.getAvailablility() - productquantity);
				productrep.save(pr);
				deliveryrep.save(d);
// try
// { 
// Thread.sleep(10000);
// }
// catch (InterruptedException e) {
// System.err.format("IOException: %s%n", e);
// }
// d.setDelivery_status("TO BE DELIVERED");
// deliveryrep.save(d);
			} else {
				return "Out of Stock";
			}
			return "To be delivered";
		} else
			return "Product not found";
	}

	@Override
	public String DeliveryStatus(String productname, int customerid) {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateStatus(String productname, int productquantity, int customerid) {
		// TODO Auto-generated method stub
		return null;
	}
}
