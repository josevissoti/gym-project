package com.project.resources;

import com.project.domains.GymProduct;
import com.project.domains.dtos.GymProductDTO;
import com.project.services.GymProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gymproduct")
public class GymProductResource {

    @Autowired
    private GymProductService gymProductService;

    @GetMapping
    public ResponseEntity<List<GymProductDTO>> findAll() {
        return ResponseEntity.ok().body(gymProductService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GymProductDTO> findById(@PathVariable Long id) {
        GymProduct obj = this.gymProductService.findById(id);
        return ResponseEntity.ok().body(new GymProductDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GymProductDTO> create(@Valid @RequestBody GymProductDTO dto) {
        GymProduct gymProduct = gymProductService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gymProduct.getIdProduct()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GymProductDTO> update(@PathVariable Long id, @Valid @RequestBody GymProductDTO objDto) {
        GymProduct obj = gymProductService.update(id, objDto);
        return ResponseEntity.ok().body(new GymProductDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GymProductDTO> delete(@PathVariable Long id) {
        gymProductService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
