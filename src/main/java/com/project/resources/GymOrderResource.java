package com.project.resources;

import com.project.domains.GymOrder;
import com.project.domains.dtos.GymOrderDTO;
import com.project.repositories.GymOrderRepository;
import com.project.services.GymOrderService;
import com.project.services.state.orderstate.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "gymorder")
public class GymOrderResource {

    @Autowired
    private GymOrderService gymOrderService;

    @Autowired
    private GymOrderRepository gymOrderRepository;

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<GymOrderDTO>> findAll() {
        return ResponseEntity.ok().body(gymOrderService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GymOrderDTO> findById(@PathVariable UUID id) {
        GymOrder obj = this.gymOrderService.findById(id);
        return ResponseEntity.ok().body(new GymOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/pay")
    public ResponseEntity<GymOrderDTO> payOrder(@PathVariable UUID id) {
        GymOrder obj = this.gymOrderService.findById(id);
        obj.initializeState(stateService);
        obj.successInPaying();
        gymOrderRepository.save(obj);
        return ResponseEntity.ok().body(new GymOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/dispatch")
    public ResponseEntity<GymOrderDTO> dispatchOrder(@PathVariable UUID id) {
        GymOrder obj = this.gymOrderService.findById(id);
        obj.initializeState(stateService);
        obj.dispatchOrder();
        gymOrderRepository.save(obj);
        return ResponseEntity.ok().body(new GymOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/cancel")
    public ResponseEntity<GymOrderDTO> cancelOrder(@PathVariable UUID id) {
        GymOrder obj = this.gymOrderService.findById(id);
        obj.initializeState(stateService);
        obj.cancelOrder();
        gymOrderRepository.save(obj);
        return ResponseEntity.ok().body(new GymOrderDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GymOrderDTO> create(@Valid @RequestBody GymOrderDTO dto) {
        GymOrder gymOrder = gymOrderService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gymOrder.getIdServiceOrder()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GymOrderDTO> update(@PathVariable UUID id, @Valid @RequestBody GymOrderDTO objDto) {
        GymOrder obj = gymOrderService.update(id, objDto);
        return ResponseEntity.ok().body(new GymOrderDTO(obj));
    }

}
