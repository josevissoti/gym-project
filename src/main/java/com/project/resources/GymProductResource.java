package com.project.resources;

import com.project.domains.dtos.GymProductDTO;
import com.project.services.GymProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
