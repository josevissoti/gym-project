package com.project.domains.dtos;

import com.project.domains.OrderItem;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class OrderItemDTO {

    private Long idProduct;

    @NotNull(message = "Field Employee cannot be null")
    private String description;

    @Digits(integer = 15, fraction = 2)
    private BigDecimal productValue;

    private int quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.idProduct = orderItem.getProduct().getIdProduct();
        this.description = orderItem.getProduct().getDescription();
        this.productValue = orderItem.getProduct().getProductValue();
        this.quantity = orderItem.getQuantity();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
