package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.DiscountRequest;
import com.product.model.Product;
import com.product.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/discount")
	public ResponseEntity<Product> applyDiscount(@RequestBody DiscountRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.applyDiscount(request));
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable String productId) {
		return ResponseEntity.ok(productService.getProductById(productId));
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
