package com.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequest {
    private String productId;
    private String discountType; // "flat" or "percentage"
    private double discountValue;
    private boolean seasonalDiscountActive;
    private double productPrice;
    private int quantity;
}
