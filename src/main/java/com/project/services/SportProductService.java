package com.project.services;

import com.project.domains.SportProduct;
import com.project.domains.dtos.SportProductDTO;
import com.project.repositories.SportProductRepository;
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
        return obj.orElse(null);
    }

}
