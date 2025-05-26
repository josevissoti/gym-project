package com.project.resources;

import com.project.domains.SportProduct;
import com.project.domains.dtos.SportProductDTO;
import com.project.services.SportProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "sportproduct")
public class SportProductResource {

    @Autowired
    private SportProductService sportProductService;

    @GetMapping
    public ResponseEntity<List<SportProductDTO>> findAll() {
        return ResponseEntity.ok().body(sportProductService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SportProductDTO> findById(@PathVariable Long id) {
        SportProduct obj = this.sportProductService.findById(id);
        return ResponseEntity.ok().body(new SportProductDTO(obj));
    }

    @PostMapping
    public ResponseEntity<SportProductDTO> create(@Valid @RequestBody SportProductDTO dto) {
        SportProduct sportProduct = sportProductService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sportProduct.getIdProduct()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SportProductDTO> update(@PathVariable Long id, @Valid @RequestBody SportProductDTO objDto) {
        SportProduct Obj = sportProductService.update(id, objDto);
        return ResponseEntity.ok().body(new SportProductDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SportProductDTO> delete(@PathVariable Long id) {
        sportProductService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
