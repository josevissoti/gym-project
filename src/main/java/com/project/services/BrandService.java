package com.project.services;

import com.project.domains.dtos.BrandDTO;
import com.project.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDTO> findAll() {
        return brandRepository.findAll().stream()
                .map(BrandDTO::new)
                .collect(Collectors.toList());
    }

}
