package com.project.resources;

import com.project.domains.Brand;
import com.project.domains.dtos.BrandDTO;
import com.project.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<BrandDTO> create(@Valid @RequestBody BrandDTO dto) {
        Brand brand = brandService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(brand.getIdBrand()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BrandDTO> update(@PathVariable Integer id, @Valid @RequestBody BrandDTO objDto) {
        Brand obj = brandService.update(id, objDto);
        return ResponseEntity.ok().body(new BrandDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BrandDTO> delete(@PathVariable Integer id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
