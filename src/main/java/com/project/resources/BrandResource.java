package com.project.resources;

import com.project.domains.Brand;
import com.project.domains.dtos.BrandDTO;
import com.project.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandResource {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll() {
        return ResponseEntity.ok().body(brandService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrandDTO> findById(@PathVariable Integer id) {
        Brand obj = this.brandService.findById(id);
        return ResponseEntity.ok().body(new BrandDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<BrandDTO> findByCnpj(@PathVariable String cnpj) {
        Brand obj = this.brandService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new BrandDTO(obj));
    }

}
