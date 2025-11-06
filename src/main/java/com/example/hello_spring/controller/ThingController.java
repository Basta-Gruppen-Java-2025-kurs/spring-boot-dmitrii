package com.example.hello_spring.controller;

import com.example.hello_spring.model.Mapper;
import com.example.hello_spring.model.dto.ThingResponseDTO;
import com.example.hello_spring.service.ThingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thing")
public class ThingController {
    private final ThingService service;
    private final Mapper mapper;

    public ThingController(ThingService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThingResponseDTO> findById(@PathVariable long id) {
        return service.findById(id).map(mapper::toResponseDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
