package com.project.services;

import com.project.domains.Brand;
import com.project.domains.GymProduct;
import com.project.domains.dtos.GymProductDTO;
import com.project.repositories.BrandRepository;
import com.project.repositories.GymProductRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GymProductService {

    @Autowired
    private GymProductRepository gymProductRepository;

    @Autowired
    private BrandRepository brandRepository;

    public List<GymProductDTO> findAll() {
        return gymProductRepository.findAll().stream()
                .map(GymProductDTO::new)
                .collect(Collectors.toList());
    }

    public GymProduct findById(Long id) {
        Optional<GymProduct> obj = gymProductRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Gym Product not found. ID: " + id));
    }

    public GymProduct create(GymProductDTO dto) {
        dto.setIdProduct(null);
        gymProductValidation(dto);
        GymProduct obj = new GymProduct(dto);
        return gymProductRepository.save(obj);
    }

    public GymProduct update(Long id, GymProductDTO objDto) {
        objDto.setIdProduct(id);
        GymProduct oldObj = findById(id);
        gymProductValidation(objDto);
        oldObj = new GymProduct(objDto);
        return gymProductRepository.save(oldObj);
    }

    public void delete(Long id) {
        GymProduct obj = findById(id);
        gymProductRepository.deleteById(id);
    }

    public void gymProductValidation(GymProductDTO dto) {
        Optional<Brand> brand = brandRepository.findById(dto.getBrand());
        if (!brand.isPresent()) {
            throw new DataIntegrityViolationException("Brand - " + dto.getBrandName() + " isn't registered.");
        }
    }

}
