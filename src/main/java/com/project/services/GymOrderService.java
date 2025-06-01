package com.project.services;

import com.project.domains.*;
import com.project.domains.dtos.GymOrderDTO;
import com.project.domains.dtos.OrderItemDTO;
import com.project.repositories.GymOrderRepository;
import com.project.repositories.GymProductRepository;
import com.project.services.exceptions.ObjectNotFoundException;
import com.project.services.strategy.orderfreight.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GymOrderService {

    @Autowired
    private GymOrderRepository gymOrderRepository;

    @Autowired
    private GymProductRepository gymProductRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private FreightService freightService;

    public List<GymOrderDTO> findAll() {
        return gymOrderRepository.findAll().stream()
                .map(GymOrderDTO::new)
                .collect(Collectors.toList());
    }

    public GymOrder findById(UUID id) {
        Optional<GymOrder> obj = gymOrderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Gym Order not found. ID: " + id));
    }

    private GymOrder newGymOrder(GymOrderDTO obj) {
        Employee employee = employeeService.findById(obj.getEmployee());
        User user = userService.findById(obj.getUser());

        GymOrder gymOrder = new GymOrder();

        if (obj.getIdServiceOrder() != null) {
            gymOrder.setIdServiceOrder(obj.getIdServiceOrder());
        }

        gymOrder.setDeadline(obj.getDeadline());
        gymOrder.setEmployee(employee);
        gymOrder.setUser(user);
        gymOrder.setDescription("Gym Order");
        gymOrder.setFreightType(obj.getFreightType());

        for (OrderItemDTO orderItemDTO : obj.getItems()) {
            Product product = gymProductRepository.findById(orderItemDTO.getIdProduct())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (!(product instanceof GymProduct gymProduct)) {
                throw new RuntimeException("Product must be a GymProduct. ID: " + orderItemDTO.getIdProduct());
            }

            OrderItem orderItem = new OrderItem(null, gymOrder, gymProduct, orderItemDTO.getQuantity());

            gymOrder.addOrderItems(orderItem);
        }

        freightService.setMapFreight(gymOrder);
        gymOrder.calculateFreight();

        return gymOrder;
    }

    public GymOrder create(GymOrderDTO objDto) {
        return gymOrderRepository.save(newGymOrder(objDto));
    }

    public GymOrder update(UUID id, GymOrderDTO objDto) {
        objDto.setIdServiceOrder(id);
        GymOrder oldObj = findById(id);
        oldObj = newGymOrder(objDto);
        return gymOrderRepository.save(oldObj);
    }

}
