package com.project.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.User;
import com.project.domains.enums.PersonRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    protected Long idPerson;

    @NotNull(message = "Field name cannot be null")
    @NotBlank(message = "Field name cannot be blank")
    protected String name;

    @NotNull(message = "Field cpf cannot be null")
    @CPF
    protected String cpf;

    @NotNull(message = "Field rg cannot be null")
    @NotBlank(message = "Field rg cannot be blank")
    protected String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createDate = LocalDate.now();

    @NotNull(message = "Field phone cannot be null")
    @NotBlank(message = "Field phone cannot be blank")
    protected String phone;

    @NotNull(message = "Field email cannot be null")
    @NotBlank(message = "Field email cannot be blank")
    protected String email;

    @NotNull(message = "Field password cannot be null")
    @NotBlank(message = "Field password cannot be blank")
    protected String password;

    private int status;

    protected Set<Integer> personType = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.idPerson = user.getIdPerson();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.rg = user.getRg();
        this.birthDate = user.getBirthDate();
        this.createDate = user.getCreateDate();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.status = user.getStatus().getIdStatus();
        this.personType.stream().map(PersonRole::toEnum).collect(Collectors.toSet());
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<PersonRole> getPersonType() {
        return personType == null ? Collections.emptySet() :
                personType.stream().map(PersonRole::toEnum)
                        .collect(Collectors.toSet());
    }

    public void addPersonType(PersonRole personRole) {
        this.personType.add(personRole.getId());
    }
}
