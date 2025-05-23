package com.project.repositories;

import com.project.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReposiroty extends JpaRepository<Employee, Long> {
}
