package com.project.resources;

import com.project.domains.GymOrder;
import com.project.domains.dtos.GymOrderDTO;
import com.project.services.GymOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "gymorder")
public class GymOrderResource {

    @Autowired
    private GymOrderService gymOrderService;

    @GetMapping
    public ResponseEntity<List<GymOrderDTO>> findAll() {
        return ResponseEntity.ok().body(gymOrderService.findAll());
    }

    @PostMapping
    public ResponseEntity<GymOrderDTO> create(@Valid @RequestBody GymOrderDTO dto) {
        GymOrder gymOrder = gymOrderService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gymOrder.getIdServiceOrder()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GymOrderDTO> update(@PathVariable Long id, @Valid @RequestBody GymOrderDTO objDto) {
        GymOrder Obj = gymOrderService.update(id, objDto);
        return ResponseEntity.ok().body(new GymOrderDTO(Obj));
    }

}
