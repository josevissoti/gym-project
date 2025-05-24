package com.project.domains;

import com.project.domains.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "academyProduct")
public class GymProduct extends Product {
    public GymProduct(Long idProduct, String description, String model, LocalDate manufacturingDate, BigDecimal productValue, int availableQuantity, Brand brand, Status status) {
        super(idProduct, description, model, manufacturingDate, productValue, availableQuantity, brand, status);
    }

    public GymProduct() {
    }
}
