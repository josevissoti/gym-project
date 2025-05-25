package com.project.services;

import com.project.domains.GymProduct;
import com.project.domains.SportProduct;
import com.project.domains.dtos.SportProductDTO;
import com.project.repositories.SportProductRepository;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportProductService {

    @Autowired
    private SportProductRepository sportProductRepository;

    public List<SportProductDTO> findAll() {
        return sportProductRepository.findAll().stream()
                .map(SportProductDTO::new)
                .collect(Collectors.toList());
    }

    public SportProduct findById(Long id) {
        Optional<SportProduct> obj = sportProductRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sport Product not found. ID: " + id));
    }

    public SportProduct findByDescription(String description) {
        Optional<SportProduct> obj = sportProductRepository.findByDescription(description);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sport Product not found. Description: " + description));
    }

}
