package com.project.domains;

import com.project.services.strategy.orderfreight.Freight;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sportOrder")
public class SportOrder extends ServiceOrder {
    public SportOrder(UUID idServiceOrder, LocalDate deadline, User user, Employee employee, List<OrderItem> orderItems) {
        super(idServiceOrder, deadline, user, employee, orderItems);
        super.setDescription("Sport Order");
    }

    public SportOrder() {
        super.setDescription("Sport Order");
    }

}
