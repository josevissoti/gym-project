package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    private Long idProduct;

    @NotBlank
    @NotNull
    private String description;

    @NotBlank
    @NotNull
    private String model;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate manufacturingDate;

    @Digits(integer = 15, fraction = 2)
    private BigDecimal productValue;

    private int availableQuantity;

    @ManyToOne
    @JoinColumn(name = "idbrand")
    private Brand brand;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    public Product() {
        this.status = Status.ACTIVATED;
    }

    public Product(Long idProduct, String description, String model, LocalDate manufacturingDate, BigDecimal productValue, int availableQuantity, Brand brand, Status status) {
        this.idProduct = idProduct;
        this.description = description;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.productValue = productValue;
        this.availableQuantity = availableQuantity;
        this.brand = brand;
        this.status = status;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, description);
    }
}
