package com.project.services;

import com.project.domains.Employee;
import com.project.domains.GymOrder;
import com.project.domains.SportOrder;
import com.project.domains.User;
import com.project.domains.dtos.GymOrderDTO;
import com.project.domains.dtos.SportOrderDTO;
import com.project.repositories.SportOrderRepository;
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

        if (obj.getIdServiceOrder().equals(2)) {
            sportOrder.setEndDate(LocalDate.now());
        }

        sportOrder.setEmployee(employee);
        sportOrder.setUser(user);
        sportOrder.setDescription(obj.getDescription());
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
