package com.project.repositories;

import com.project.domains.AcademyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcademyOrderRepository extends JpaRepository<AcademyOrder, UUID> {
}
