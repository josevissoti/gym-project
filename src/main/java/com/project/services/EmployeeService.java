package com.project.services;

import com.project.domains.Employee;
import com.project.domains.dtos.EmployeeDTO;
import com.project.repositories.EmployeeRepository;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public Employee findById(Long id) {
        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Employee not found. ID: " + id));
    }

    public Employee findByCpf(String cpf) {
        Optional<Employee> obj = employeeRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Employee not found. CPF: " + cpf));
    }

    public Employee findByEmail(String email) {
        Optional<Employee> obj = employeeRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Employee not found. Email: " + email));
    }
}
