package com.project.resources;

import com.project.domains.SportOrder;
import com.project.domains.dtos.SportOrderDTO;
import com.project.repositories.SportOrderRepository;
import com.project.services.SportOrderService;
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
@RequestMapping(value = "sportorder")
public class SportOrderResource {

    @Autowired
    private SportOrderService sportOrderService;

    @Autowired
    private SportOrderRepository sportOrderRepository;

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<SportOrderDTO>> findAll() {
        return ResponseEntity.ok().body(sportOrderService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SportOrderDTO> findById(@PathVariable UUID id) {
        SportOrder obj = this.sportOrderService.findById(id);
        return ResponseEntity.ok().body(new SportOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/pay")
    public ResponseEntity<SportOrderDTO> payOrder(@PathVariable UUID id) {
        SportOrder obj = this.sportOrderService.findById(id);
        obj.initializeState(stateService);
        obj.successInPaying();
        sportOrderRepository.save(obj);
        return ResponseEntity.ok().body(new SportOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/dispatch")
    public ResponseEntity<SportOrderDTO> dispatchOrder(@PathVariable UUID id) {
        SportOrder obj = this.sportOrderService.findById(id);
        obj.initializeState(stateService);
        obj.dispatchOrder();
        sportOrderRepository.save(obj);
        return ResponseEntity.ok().body(new SportOrderDTO(obj));
    }

    @GetMapping(value = "/{id}/cancel")
    public ResponseEntity<SportOrderDTO> cancelOrder(@PathVariable UUID id) {
        SportOrder obj = this.sportOrderService.findById(id);
        obj.initializeState(stateService);
        obj.cancelOrder();
        sportOrderRepository.save(obj);
        return ResponseEntity.ok().body(new SportOrderDTO(obj));
    }

    @PostMapping
    public ResponseEntity<SportOrderDTO> create(@Valid @RequestBody SportOrderDTO dto) {
        SportOrder sportOrder = sportOrderService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sportOrder.getIdServiceOrder()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SportOrderDTO> update(@PathVariable UUID id, @Valid @RequestBody SportOrderDTO objDto) {
        SportOrder obj = sportOrderService.update(id, objDto);
        return ResponseEntity.ok().body(new SportOrderDTO(obj));
    }

}
