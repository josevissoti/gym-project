package com.project.domains;

import com.project.domains.dtos.GymProductDTO;
import com.project.domains.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gymProduct")
public class GymProduct extends Product {
    public GymProduct(Long idProduct, String description, String model, LocalDate manufacturingDate, BigDecimal productValue, int availableQuantity, Brand brand, Status status) {
        super(idProduct, description, model, manufacturingDate, productValue, availableQuantity, brand, status);
    }

    public GymProduct() {
    }

    public GymProduct(GymProductDTO dto) {
        this.idProduct = dto.getIdProduct();
        this.description = dto.getDescription();
        this.model = dto.getModel();
        this.manufacturingDate = dto.getManufacturingDate();
        this.productValue = dto.getProductValue();
        this.availableQuantity = dto.getAvailableQuantity();
        this.brand = new Brand();
        this.brand.setIdBrand(dto.getBrand());
    }

}
