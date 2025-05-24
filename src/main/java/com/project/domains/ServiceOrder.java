package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.services.state.orderstate.AwaitingPaymentState;
import com.project.services.state.orderstate.State;
import com.project.services.strategy.orderfreight.Freight;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "serviceOrder")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @SequenceGenerator(name = "seq_serviceOrder", sequenceName = "seq_serviceOrder", allocationSize = 1)
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

    @OneToMany(mappedBy = "serviceOrder")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Transient
    private State currentState;

    public ServiceOrder() {
        this.currentState = new AwaitingPaymentState(this);
    }

    public ServiceOrder(UUID idServiceOrder, LocalDate startDate, LocalDate endDate, LocalDate deadline, User user, Employee employee, Freight freight) {
        this.idServiceOrder = idServiceOrder;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.user = user;
        this.employee = employee;

        this.currentState = new AwaitingPaymentState(this);
    }

    public void successInPaying() {
        try {
            this.currentState.successInPaying();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void dispatchOrder() {
        try {
            this.currentState.cancelOrder();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void cancelOrder() {
        try {
            this.currentState.dispatchOrder();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
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

    public void addOrderItem(Product product, int quantity) {

    }
}
