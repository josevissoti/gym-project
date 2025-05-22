package services;

import domains.enums.Brand;
import domains.enums.Product;
import domains.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BrandRepository;
import repositories.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ProductRepository productRepo;

    public void initDB() {
        // Create brands
        Brand brand01 = new Brand(
                0,
                "Nike",
                "12.345.678/0001-90",
                "United States",
                "contact@nike.com",
                Status.ACTIVATED
        );

        Brand brand02 = new Brand(
                0,
                "Adidas",
                "98.765.432/0001-21",
                "Germany",
                "contact@adidas.com",
                Status.ACTIVATED
        );

        Brand brand03 = new Brand(
                0,
                "Samsung",
                "11.223.344/0001-55",
                "South Korea",
                "contact@samsung.com",
                Status.ACTIVATED
        );

        // Save brands first to generate IDs
        brandRepo.save(brand01);
        brandRepo.save(brand02);
        brandRepo.save(brand03);

        // Create products
        Product product01 = new Product(
                0L,
                "Air Max Running Shoes",
                "AIRMAX-2023",
                LocalDate.now(),
                new BigDecimal("400"),
                150,
                brand01,
                Status.ACTIVATED
        );

        Product product02 = new Product(
                0L,
                "Ultraboost Shoes",
                "ULTRABOOST-22",
                LocalDate.now(),
                new BigDecimal("799.99"),
                80,
                brand02,
                Status.ACTIVATED
        );

        Product product03 = new Product(
                0L,
                "Galaxy S23 Smartphone",
                "GALAXY-S23",
                LocalDate.now(),
                new BigDecimal("4599.00"),
                200,
                brand03,
                Status.ACTIVATED
        );

        Product product04 = new Product(
                0L,
                "T-shirt Sportswear",
                "TSHIRT-SPORT",
                LocalDate.now(),
                new BigDecimal("129.90"),
                350,
                brand01,
                Status.ACTIVATED
        );

        // Save products
        productRepo.save(product01);
        productRepo.save(product02);
        productRepo.save(product03);
        productRepo.save(product04);

    }
}
