package com.example.demo.Services;

import java.util.Optional;
import com.example.demo.entity.Product;

public interface ProductService {
	String createproduct(int pid, String pname, int availability, float price);

	Optional<Product> productCheck(String pname);
}
