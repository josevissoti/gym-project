package com.project.services;

import com.project.domains.GymProduct;
import com.project.domains.dtos.GymProductDTO;
import com.project.repositories.GymProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public GymProduct findById(Long id) {
        Optional<GymProduct> obj = gymProductRepository.findById(id);
        return obj.orElse(null);
    }
}
