package com.project.repositories;

import com.project.domains.AcademyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyProductRepository extends JpaRepository<AcademyProduct, Long> {
}
