package com.project.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.domains.enums.PersonRole;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "user")
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
