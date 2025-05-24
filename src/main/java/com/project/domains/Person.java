package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.enums.PersonRole;
import com.project.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1)
    protected Long idPerson;

    @NotBlank
    @NotNull
    protected String name;

    @NotBlank
    @NotNull
    @Column(unique = true)
    protected String cpf;

    @NotBlank
    @NotNull
    protected String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createDate = LocalDate.now();

    @NotBlank
    @NotNull
    protected String phone;

    @NotBlank
    @NotNull
    @Column(unique = true)
    protected String email;

    @NotBlank
    @NotNull
    protected String password;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    protected Status status;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "person_type")
    protected Set<Integer> personRole = new HashSet<>();

    public Person() {
        addPersonRole(PersonRole.USER);
    }

    public Person(Long idPerson, String name, String cpf, String rg, LocalDate birthDate, LocalDate createDate, String phone, String email, String password, Status status) {
        this.idPerson = idPerson;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.createDate = createDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
