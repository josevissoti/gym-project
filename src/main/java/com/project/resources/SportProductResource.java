package com.project.resources;

import com.project.domains.SportProduct;
import com.project.domains.dtos.SportProductDTO;
import com.project.services.SportProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/description/{description}")
    public ResponseEntity<SportProductDTO> findByDescription(@PathVariable String description) {
        SportProduct obj = this.sportProductService.findByDescription(description);
        return ResponseEntity.ok().body(new SportProductDTO(obj));
    }

}
