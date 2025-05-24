package com.project.resources;

import com.project.domains.dtos.SportOrderDTO;
import com.project.services.SportOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "sportorder")
public class SportOrderResource {

    @Autowired
    private SportOrderService sportOrderService;

    @GetMapping
    public ResponseEntity<List<SportOrderDTO>> findAll() {
        return ResponseEntity.ok().body(sportOrderService.findAll());
    }

}
