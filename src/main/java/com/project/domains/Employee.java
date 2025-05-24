package com.project.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.domains.dtos.EmployeeDTO;
import com.project.domains.enums.PersonRole;
import com.project.domains.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "employees")
public class Employee extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Employee() {
        super();
        addPersonRole(PersonRole.USER);
        addPersonRole(PersonRole.EMPLOYEE);
    }

    public Employee(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password, Status status) {
        super(idPerson, name, cpf, rg, birthDate, createDate, phone, email, password, status);
        addPersonRole(PersonRole.USER);
        addPersonRole(PersonRole.EMPLOYEE);
    }

    public Employee(EmployeeDTO dto) {
        this.idPerson = dto.getIdPerson();
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.rg = dto.getRg();
        this.birthDate = dto.getBirthDate();
        this.createDate = dto.getCreateDate();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.status = Status.toEnum(dto.getStatus());
        this.personRole = dto.getPersonType().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
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
