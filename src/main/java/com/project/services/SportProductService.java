package com.project.services;

import com.project.domains.Brand;
import com.project.domains.SportProduct;
import com.project.domains.dtos.SportProductDTO;
import com.project.repositories.BrandRepository;
import com.project.repositories.SportProductRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
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

    @Autowired
    private BrandRepository brandRepository;

    public List<SportProductDTO> findAll() {
        return sportProductRepository.findAll().stream()
                .map(SportProductDTO::new)
                .collect(Collectors.toList());
    }

    public SportProduct findById(Long id) {
        Optional<SportProduct> obj = sportProductRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sport Product not found. ID: " + id));
    }

    public SportProduct create(SportProductDTO dto) {
        dto.setIdProduct(null);
        sportProductValidation(dto);
        SportProduct obj = new SportProduct(dto);
        return sportProductRepository.save(obj);
    }

    public SportProduct update(Long id, SportProductDTO objDto) {
        objDto.setIdProduct(id);
        SportProduct oldObj = findById(id);
        sportProductValidation(objDto);
        oldObj = new SportProduct(objDto);
        return sportProductRepository.save(oldObj);
    }

    public void delete(Long id) {
        SportProduct obj = findById(id);
        sportProductRepository.deleteById(id);
    }

    public void sportProductValidation(SportProductDTO dto) {
        Optional<Brand> brand = brandRepository.findById(dto.getBrand());
        if (!brand.isPresent()) {
            throw new DataIntegrityViolationException("Brand - " + dto.getBrandName() + " isn't registered.");
        }
    }

}
