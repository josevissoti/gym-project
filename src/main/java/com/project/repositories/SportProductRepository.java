package com.project.repositories;

import com.project.domains.SportProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportProductRepository extends JpaRepository<SportProduct, Long> {

}
