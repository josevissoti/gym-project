package com.project.services;

import com.project.domains.Employee;
import com.project.domains.GymOrder;
import com.project.domains.User;
import com.project.domains.dtos.GymOrderDTO;
import com.project.repositories.GymOrderRepository;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GymOrderService {

    @Autowired
    private GymOrderRepository gymOrderRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

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

        if (obj.getIdServiceOrder().equals(2)) {
            gymOrder.setEndDate(LocalDate.now());
        }

        gymOrder.setEmployee(employee);
        gymOrder.setUser(user);
        gymOrder.setDescription(obj.getDescription());
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
