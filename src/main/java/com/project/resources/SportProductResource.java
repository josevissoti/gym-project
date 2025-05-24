package com.project.resources;

import com.project.domains.dtos.SportProductDTO;
import com.project.services.SportProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
