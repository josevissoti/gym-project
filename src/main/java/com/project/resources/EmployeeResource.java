package com.project.resources;

import com.project.domains.Employee;
import com.project.domains.dtos.EmployeeDTO;
import com.project.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        Employee employee = employeeService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getIdPerson()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO objDto) {
        Employee Obj = employeeService.update(id, objDto);
        return ResponseEntity.ok().body(new EmployeeDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
