package com.project.services;

import com.project.domains.Brand;
import com.project.domains.Product;
import com.project.domains.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.repositories.BrandRepository;
import com.project.repositories.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class DBService {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ProductRepository productRepo;

    public void initDB() {
        // Create brands
        Brand brand01 = new Brand(
                null,
                "Nike",
                "12.345.678/0001-90",
                "United States",
                "contact@nike.com",
                Status.ACTIVATED
        );

        Brand brand02 = new Brand(
                null,
                "Adidas",
                "98.765.432/0001-21",
                "Germany",
                "contact@adidas.com",
                Status.ACTIVATED
        );

        Brand brand03 = new Brand(
                null,
                "Samsung",
                "11.223.344/0001-55",
                "South Korea",
                "contact@samsung.com",
                Status.ACTIVATED
        );

        // Create products
        Product product01 = new Product(
                null,
                "Air Max Running Shoes",
                "AIRMAX-2023",
                LocalDate.of(2024, Month.MARCH, 15),
                new BigDecimal("400.00"),
                150,
                brand01,
                Status.ACTIVATED
        );

        Product product02 = new Product(
                null,
                "Ultraboost Shoes",
                "ULTRABOOST-22",
                LocalDate.of(2023, Month.DECEMBER, 23),
                new BigDecimal("799.99"),
                80,
                brand02,
                Status.ACTIVATED
        );

        Product product03 = new Product(
                null,
                "Galaxy S23 Smartphone",
                "GALAXY-S23",
                LocalDate.of(2025, Month.JANUARY, 4),
                new BigDecimal("4599.00"),
                200,
                brand03,
                Status.ACTIVATED
        );

        Product product04 = new Product(
                null,
                "T-shirt Sportswear",
                "TSHIRT-SPORT",
                LocalDate.of(2024, Month.SEPTEMBER, 1),
                new BigDecimal("129.90"),
                350,
                brand01,
                Status.ACTIVATED
        );

        brandRepo.save(brand01);
        brandRepo.save(brand02);
        brandRepo.save(brand03);
        productRepo.save(product01);
        productRepo.save(product02);
        productRepo.save(product03);
        productRepo.save(product04);

    }
}
