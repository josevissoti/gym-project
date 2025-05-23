package com.project.domains;

import com.project.services.strategy.orderfreight.Freight;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sport")
public class SportOrder extends ServiceOrder {
    public SportOrder(UUID idServiceOrder, LocalDate startDate, LocalDate endDate, LocalDate deadline, User user, Employee employee, Freight freight) {
        super(idServiceOrder, startDate, endDate, deadline, user, employee, freight);
        super.setDescription("Sport Order");
    }

    public SportOrder() {
        super.setDescription("Sport Order");
    }
}
