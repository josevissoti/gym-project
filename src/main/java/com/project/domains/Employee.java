package com.project.domains;

import com.project.domains.enums.PersonRole;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

    private List<Order> orders = new ArrayList<>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
