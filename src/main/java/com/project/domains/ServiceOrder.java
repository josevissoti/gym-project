package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "serviceOrder")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idServiceOrder;

    @NotBlank
    @NotNull
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "idemployee")
    private User user;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private Employee employee;

    public ServiceOrder() {
    }

    public ServiceOrder(UUID idServiceOrder, String description, LocalDate startDate, LocalDate endDate, LocalDate deadline, User user, Employee employee) {
        this.idServiceOrder = idServiceOrder;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.user = user;
        this.employee = employee;
    }

    public UUID getIdServiceOrder() {
        return idServiceOrder;
    }

    public void setIdServiceOrder(UUID idServiceOrder) {
        this.idServiceOrder = idServiceOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder serviceOrder = (ServiceOrder) o;
        return Objects.equals(idServiceOrder, serviceOrder.idServiceOrder) && Objects.equals(description, serviceOrder.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServiceOrder, description);
    }
}
