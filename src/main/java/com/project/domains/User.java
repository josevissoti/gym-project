package com.project.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.domains.dtos.UserDTO;
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
@Table(name = "users")
public class User extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public User() {
        super();
        addPersonRole(PersonRole.USER);
    }

    public User(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password, Status status) {
        super(idPerson, name, cpf, rg, birthDate, createDate, phone, email, password, status);
        addPersonRole(PersonRole.USER);
    }

    public User(UserDTO dto) {
        this.idPerson = dto.getIdPerson();
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.rg = dto.getRg();
        this.birthDate = dto.getBirthDate();
        this.createDate = dto.getCreateDate();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.status = Status.toEnum(dto.getStatus());
        this.personRole = dto.getPersonType().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addPersonRole(PersonRole.USER);
    }

    public List<ServiceOrder> getOrders() {
        return serviceOrders;
    }

    public void setOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
