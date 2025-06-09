package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.services.exceptions.IllegalOrderStateException;
import com.project.services.state.orderstate.AwaitingPaymentState;
import com.project.services.state.orderstate.State;
import com.project.services.state.orderstate.StateService;
import com.project.services.strategy.orderfreight.Freight;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
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

    @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Transient
    private Freight freight;

    @NotBlank
    @NotNull
    private String freightType;

    @Digits(integer = 15, fraction = 6)
    private BigDecimal freightValue;

    @Transient
    private State state;

    @NotBlank
    @NotNull
    private String currentState;

    public ServiceOrder() {
        this.state = new AwaitingPaymentState();
        this.currentState = state.getType();
    }

    public ServiceOrder(UUID idServiceOrder, LocalDate deadline, User user, Employee employee, String freightType) {
        this.idServiceOrder = idServiceOrder;
        this.deadline = deadline;
        this.user = user;
        this.employee = employee;
        this.orderItems = new ArrayList<>();
        this.freightType = freightType;
        this.state = new AwaitingPaymentState();
        this.currentState = state.getType();
    }

    public void initializeState(StateService stateService) {
        this.state = stateService.getState(this.currentState);
    }

    public void calculateFreight() {
        if (this.freight == null) {
            throw new IllegalStateException("Freight strategy not set");
        }
        this.freightValue = this.freight.freightCalcule(this.orderItems);
    }

    public void successInPaying() {
        try {
            this.state.successInPaying(this);
            this.currentState = state.getType();
        } catch (IllegalOrderStateException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalOrderStateException("Failed to process payment: " + e.getMessage());
        }
    }

    public void dispatchOrder() {
        try {
            this.state.dispatchOrder(this);
            this.currentState = state.getType();
        } catch (IllegalOrderStateException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalOrderStateException("Failed to dispatch order: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        try {
            this.state.cancelOrder(this);
            this.currentState = state.getType();
        } catch (IllegalOrderStateException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalOrderStateException("Failed to cancel order: " + e.getMessage());
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

    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setServiceOrder(this);
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Freight getFreight() {
        return freight;
    }

    public void setFreight(Freight freight) {
        this.freight = freight;
    }

    public String getFreightType() {
        return freightType;
    }

    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    public BigDecimal getFreightValue() {
        return freightValue;
    }

    public void setFreightValue(BigDecimal freightValue) {
        this.freightValue = freightValue;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
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
}
