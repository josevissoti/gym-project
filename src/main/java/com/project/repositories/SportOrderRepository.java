package com.project.repositories;

import com.project.domains.SportOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SportOrderRepository extends JpaRepository<SportOrder, UUID> {
}
