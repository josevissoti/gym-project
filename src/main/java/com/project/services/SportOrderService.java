package com.project.services;

import com.project.domains.dtos.SportOrderDTO;
import com.project.repositories.SportOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportOrderService {

    @Autowired
    private SportOrderRepository sportOrderRepository;

    public List<SportOrderDTO> findAll() {
        return sportOrderRepository.findAll().stream()
                .map(SportOrderDTO::new)
                .collect(Collectors.toList());
    }
}
