package com.project.domains;

import com.project.domains.enums.PersonRole;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Person {

    protected Long idPerson;
    protected String name;
    protected String cpf;
    protected String rg;
    protected LocalDate birthDate;
    protected LocalDate createDate;
    protected String phone;
    protected String email;
    protected String password;
    protected Set<Integer> personRole = new HashSet<>();

    public Person() {
        addPersonRole(PersonRole.USER);
    }

    public Person(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password) {
        this.idPerson = idPerson;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.createDate = createDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        addPersonRole(PersonRole.USER);
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

    public Set<PersonRole> getPersonRole() {
        return personRole.stream().map(PersonRole::toEnum).collect(Collectors.toSet());
    }

    public void addPersonRole(PersonRole personRole) {
        this.personRole.add(personRole.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson) && Objects.equals(cpf, person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, cpf);
    }
}
