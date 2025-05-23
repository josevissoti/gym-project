package com.project.services;

import com.project.domains.*;
import com.project.domains.enums.Status;
import com.project.repositories.*;
import com.project.services.strategy.orderfreight.AirFreight;
import com.project.services.strategy.orderfreight.LandFreight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class DBService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EmployeeReposiroty employeeReposiroty;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AcademyOrderRepository academyOrderRepository;

    @Autowired
    private SportOrderRepository sportOrderRepository;

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

        Employee employee01 = new Employee(
                null,
                "Luis Silva",
                "847.521.482-12",
                "58.552.148-7",
                LocalDate.of(2001, Month.APRIL, 14),
                LocalDate.now(),
                "048995142578",
                "luissilva@email.com",
                "LuisSilva123"
        );

        Employee employee02 = new Employee(
                null,
                "Ana Clara",
                "548.241.846-27",
                "95.017.885-9",
                LocalDate.of(1995, Month.OCTOBER, 7),
                LocalDate.now(),
                "25485142684",
                "anaclara@email.com",
                "AnaClara123"
        );

        User user01 = new User(
                null,
                "Sebastiao",
                "455.233.789-63",
                "58.248.336-8",
                LocalDate.of(1986, Month.MAY, 30),
                LocalDate.now(),
                "85442695517",
                "sebastiao@email.com",
                "Sebastiao123"
        );

        User user02 = new User(
                null,
                "Emilly",
                "578.225.369-77",
                "42.845.475-8",
                LocalDate.of(1986, Month.JULY, 19),
                LocalDate.now(),
                "17885695233",
                "emilly@email.com",
                "Emilly123"
        );

        AcademyOrder academyOrder01 = new AcademyOrder(
                null,
                LocalDate.now(),
                LocalDate.of(2025, Month.MAY, 27),
                LocalDate.of(2025, Month.MAY, 30),
                user02,
                employee01,
                new AirFreight()
        );

        SportOrder sportOrder01 = new SportOrder(
                null,
                LocalDate.now(),
                LocalDate.of(2025, Month.JUNE, 5),
                LocalDate.of(2025, Month.JUNE, 10),
                user01,
                employee02,
                new LandFreight()
        );

        brandRepository.save(brand01);
        brandRepository.save(brand02);
        brandRepository.save(brand03);
        productRepository.save(product01);
        productRepository.save(product02);
        productRepository.save(product03);
        productRepository.save(product04);
        employeeReposiroty.save(employee01);
        employeeReposiroty.save(employee02);
        userRepository.save(user01);
        userRepository.save(user02);
        academyOrderRepository.save(academyOrder01);
        sportOrderRepository.save(sportOrder01);
    }
}
