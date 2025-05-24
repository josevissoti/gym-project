package com.project.repositories;

import com.project.domains.GymOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GymOrderRepository extends JpaRepository<GymOrder, UUID> {
}
