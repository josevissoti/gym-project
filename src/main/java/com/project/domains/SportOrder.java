package com.project.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sportOrder")
public class SportOrder extends ServiceOrder {
    public SportOrder(UUID idServiceOrder, LocalDate deadline, User user, Employee employee, String freightType) {
        super(idServiceOrder, deadline, user, employee, freightType);
        super.setDescription("Sport Order");
    }

    public SportOrder() {
        super.setDescription("Sport Order");
    }

}
