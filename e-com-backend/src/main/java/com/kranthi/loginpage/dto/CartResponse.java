package com.kranthi.loginpage.dto;

public class CartResponse {

    private Long productId;
    private int quantity;

    public CartResponse(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
