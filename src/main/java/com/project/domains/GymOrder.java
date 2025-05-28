package com.project.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "gymOrder")
public class GymOrder extends ServiceOrder {

    public GymOrder(UUID idServiceOrder, LocalDate deadline, User user, Employee employee, String freightType) {
        super(idServiceOrder, deadline, user, employee, freightType);
        super.setDescription("Gym Order");
    }

    public GymOrder() {
        super.setDescription("Gym Order");
    }

}
