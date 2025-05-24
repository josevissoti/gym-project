package com.project.domains;

import com.project.services.strategy.orderfreight.Freight;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "academyOrder")
public class GymOrder extends ServiceOrder {

    public GymOrder(UUID idServiceOrder, LocalDate deadline, User user, Employee employee, Freight freight) {
        super(idServiceOrder, deadline, user, employee, freight);
        super.setDescription("Academy Order");
    }

    public GymOrder() {
        super.setDescription("Academy Order");
    }

    @Override
    public void addOrderItem(Product product, int quantity) {
        if (product instanceof Product) {
            super.addOrderItem(product, quantity);
        } else {
            throw new IllegalArgumentException("Invalid Product");
        }
    }
}
