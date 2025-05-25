package com.project.repositories;

import com.project.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByCpf(String cpf);

    Optional<Employee> findByEmail(String email);


}
