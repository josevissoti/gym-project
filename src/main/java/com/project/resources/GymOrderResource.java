package com.project.resources;

import com.project.domains.dtos.GymOrderDTO;
import com.project.services.GymOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
