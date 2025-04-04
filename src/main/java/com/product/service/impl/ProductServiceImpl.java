package com.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.BadRequestException;
import com.product.model.DiscountRequest;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
    private ProductRepository productRepository;

	public Product applyDiscount(DiscountRequest request) {
    	 boolean existsById = this.productRepository.existsById(request.getProductId());
    	if(existsById) {
    		throw new BadRequestException("Product Id already exists");
    	}
        if (request.getQuantity() <= 0) {
            throw new BadRequestException("Product is out of stock.");
        }

        double basePrice = request.getProductPrice();
        double discount = 0;

        switch (request.getDiscountType().toLowerCase()) {
            case "flat":
                discount = request.getDiscountValue();
                break;
            case "percentage":
                discount = basePrice * (request.getDiscountValue() / 100);
                break;
            default:
                throw new BadRequestException("Invalid discount type.");
        }

        if (request.isSeasonalDiscountActive()) {
            discount += basePrice * 0.25; // 25% additional seasonal discount
        }

        double finalPrice = basePrice - discount;
        if (finalPrice < 0) finalPrice = 0;

        Product newProduct = Product.builder()
                .productId(request.getProductId())
                .productPrice(basePrice)
                .quantity(request.getQuantity())
                .discountedPrice(finalPrice)
                .seasonalDiscountActive(request.isSeasonalDiscountActive())
                .build();

        return productRepository.save(newProduct);
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new BadRequestException("Product not found"));
    }

	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
}
