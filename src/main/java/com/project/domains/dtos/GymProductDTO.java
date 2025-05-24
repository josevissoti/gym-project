package com.project.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.GymProduct;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GymProductDTO {

    private Long idProduct;

    @NotNull(message = "Field description cannot be null")
    @NotBlank(message = "Field description cannot be blank")
    private String description;

    @NotNull(message = "Field model cannot be null")
    @NotBlank(message = "Field model cannot be blank")
    private String model;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate manufacturingDate;

    @NotNull(message = "Field productValue cannot be null")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal productValue;

    @NotNull(message = "Field availableQuantity cannot be null")
    private int availableQuantity;

    @NotNull(message = "Field Brand cannot be null")
    private Integer brand;
    private String brandName;
    private String email;

    private int status;

    public GymProductDTO() {
    }

    public GymProductDTO(GymProduct gymProduct) {
        this.idProduct = gymProduct.getIdProduct();
        this.description = gymProduct.getDescription();
        this.model = gymProduct.getModel();
        this.manufacturingDate = gymProduct.getManufacturingDate();
        this.productValue = gymProduct.getProductValue();
        this.availableQuantity = gymProduct.getAvailableQuantity();
        this.brand = gymProduct.getBrand().getIdBrand();
        this.brandName = gymProduct.getBrand().getBrandName();
        this.email = gymProduct.getBrand().getEmail();
        this.status = gymProduct.getStatus().getIdStatus();
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
