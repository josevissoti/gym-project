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
@Table(name = "employees")
public class Employee extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Employee(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password) {
        super(idPerson, name, cpf, rg, birthDate, createDate, phone, email, password);
        addPersonRole(PersonRole.USER);
        addPersonRole(PersonRole.EMPLOYEE);
    }

    public Employee() {
        super();
        addPersonRole(PersonRole.USER);
        addPersonRole(PersonRole.EMPLOYEE);
    }

    public List<ServiceOrder> getOrders() {
        return serviceOrders;
    }

    public void setOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
