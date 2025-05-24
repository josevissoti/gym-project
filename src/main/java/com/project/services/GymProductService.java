package com.project.services;

import com.project.domains.dtos.GymProductDTO;
import com.project.repositories.GymProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymProductService {

    @Autowired
    private GymProductRepository gymProductRepository;

    public List<GymProductDTO> findAll() {
        return gymProductRepository.findAll().stream()
                .map(GymProductDTO::new)
                .collect(Collectors.toList());
    }
}
