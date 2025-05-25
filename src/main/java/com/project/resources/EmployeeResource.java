package com.project.resources;

import com.project.domains.Employee;
import com.project.domains.dtos.EmployeeDTO;
import com.project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        Employee obj = this.employeeService.findById(id);
        return ResponseEntity.ok().body(new EmployeeDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<EmployeeDTO> findByCpf(@PathVariable String cpf) {
        Employee obj = this.employeeService.findByCpf(cpf);
        return ResponseEntity.ok().body(new EmployeeDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<EmployeeDTO> findByEmail(@PathVariable String email) {
        Employee obj = this.employeeService.findByEmail(email);
        return ResponseEntity.ok().body(new EmployeeDTO(obj));
    }

}
