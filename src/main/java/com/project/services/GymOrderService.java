package com.project.services;

import com.project.domains.dtos.GymOrderDTO;
import com.project.repositories.GymOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymOrderService {

    @Autowired
    private GymOrderRepository gymOrderRepository;

    public List<GymOrderDTO> findAll() {
        return gymOrderRepository.findAll().stream()
                .map(GymOrderDTO::new)
                .collect(Collectors.toList());
    }

}
