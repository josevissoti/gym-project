package com.project.repositories;

import com.project.domains.GymProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymProductRepository extends JpaRepository<GymProduct, Long> {

    Optional<GymProduct> findByDescription(String description);


}
