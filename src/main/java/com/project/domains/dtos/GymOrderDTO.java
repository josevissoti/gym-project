package com.project.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.GymOrder;
import com.project.services.state.orderstate.State;
import com.project.services.strategy.orderfreight.Freight;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GymOrderDTO {

    private UUID idServiceOrder;

    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deadline;

    @NotNull(message = "Field Employee cannot be null")
    private Long employee;
    private String nameEmployee;

    @NotNull(message = "Field User cannot be null")
    private Long user;
    private String nameUser;

    private List<OrderItemDTO> items;

    public GymOrderDTO() {
    }

    public GymOrderDTO(GymOrder gymOrder) {
        this.idServiceOrder = gymOrder.getIdServiceOrder();
        this.description = gymOrder.getDescription();
        this.startDate = gymOrder.getStartDate();
        this.endDate = gymOrder.getEndDate();
        this.deadline = gymOrder.getDeadline();
        this.employee = gymOrder.getEmployee().getIdPerson();
        this.nameEmployee = gymOrder.getEmployee().getName();
        this.user = gymOrder.getUser().getIdPerson();
        this.nameUser = gymOrder.getUser().getName();
        this.items = gymOrder.getOrderItems().stream()
                .map(OrderItemDTO::new)
                .collect(Collectors.toList());
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

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
