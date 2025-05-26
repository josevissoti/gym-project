package com.project.services;

import com.project.domains.Brand;
import com.project.domains.dtos.BrandDTO;
import com.project.repositories.BrandRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Brand findById(Integer id) {
        Optional<Brand> obj = brandRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Brand not found. ID: " + id));
    }

    public Brand findByCnpj(String cnpj) {
        Optional<Brand> obj = brandRepository.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Brand not found. CNPJ: " + cnpj));
    }

    public Brand create(BrandDTO dto) {
        dto.setIdBrand(null);
        Brand obj = new Brand(dto);
        return brandRepository.save(obj);
    }

    public Brand update(Integer id, BrandDTO objDto) {
        objDto.setIdBrand(id);
        Brand oldObj = findById(id);
        brandValidation(objDto);
        oldObj = new Brand(objDto);
        return brandRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Brand obj = findById(id);
        if (obj.getProducts().size() > 0) {
            throw new DataIntegrityViolationException("Brand cannot be Deleted because has linked Orders");
        }
        brandRepository.deleteById(id);
    }

    public void brandValidation(BrandDTO dto) {
        Optional<Brand> obj = brandRepository.findByCnpj(dto.getCnpj());
        if (obj.isPresent() && obj.get().getIdBrand() != dto.getIdBrand()) {
            throw new DataIntegrityViolationException("CNPJ already registered.");
        }
    }

}
