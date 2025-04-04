package com.product.service;

import java.util.List;

import com.product.model.DiscountRequest;
import com.product.model.Product;

public interface IProductService {

	 public Product applyDiscount(DiscountRequest request);
	 
	 public Product getProductById(String productId);
	 
	 public List<Product> getAllProducts();
}
