package com.project.services;

import com.project.domains.*;
import com.project.domains.dtos.GymOrderDTO;
import com.project.domains.dtos.OrderItemDTO;
import com.project.domains.dtos.SportOrderDTO;
import com.project.repositories.SportOrderRepository;
import com.project.repositories.SportProductRepository;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SportOrderService {

    @Autowired
    private SportOrderRepository sportOrderRepository;

    @Autowired
    private SportProductRepository sportProductRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    public List<SportOrderDTO> findAll() {
        return sportOrderRepository.findAll().stream()
                .map(SportOrderDTO::new)
                .collect(Collectors.toList());
    }

    public SportOrder findById(UUID id) {
        Optional<SportOrder> obj = sportOrderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sport Order not found. ID: " + id));
    }

    private SportOrder newSportOrder(SportOrderDTO obj) {
        Employee employee = employeeService.findById(obj.getEmployee());
        User user = userService.findById(obj.getUser());

        SportOrder sportOrder = new SportOrder();

        if (obj.getIdServiceOrder() != null) {
            sportOrder.setIdServiceOrder(obj.getIdServiceOrder());
        }

        sportOrder.setDeadline(obj.getDeadline());
        sportOrder.setEmployee(employee);
        sportOrder.setUser(user);
        sportOrder.setDescription("Sport Order");

        for (OrderItemDTO orderItemDTO : obj.getItems()) {
            Product product = sportProductRepository.findById(orderItemDTO.getIdProduct())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (!(product instanceof SportProduct sportProduct)) {
                throw new RuntimeException("Product must be a GymProduct. ID: " + orderItemDTO.getIdProduct());
            }

            OrderItem orderItem = new OrderItem(null, sportOrder, sportProduct, orderItemDTO.getQuantity());

            sportOrder.addOrderItems(orderItem);
        }

        return sportOrder;
    }

    public SportOrder create(SportOrderDTO objDto) {
        return sportOrderRepository.save(newSportOrder(objDto));
    }

    public SportOrder update(UUID id, SportOrderDTO objDto) {
        objDto.setIdServiceOrder(id);
        SportOrder oldObj = findById(id);
        oldObj = newSportOrder(objDto);
        return sportOrderRepository.save(oldObj);
    }
}
