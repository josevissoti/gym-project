package com.project.domains;

import com.project.domains.enums.PersonRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private List<Order> orders = new ArrayList<>();

    public User(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password) {
        super(idPerson, name, cpf, rg, birthDate, createDate, phone, email, password);
        addPersonRole(PersonRole.USER);
    }

    public User() {
        super();
        addPersonRole(PersonRole.USER);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
