package com.example.hello_spring.controller;

import com.example.hello_spring.model.Mapper;
import com.example.hello_spring.model.dto.ThingResponseDTO;
import com.example.hello_spring.model.dto.ThingSearchRequestDTO;
import com.example.hello_spring.service.ThingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find")
    public ResponseEntity<List<ThingResponseDTO>> findByParams(@RequestParam(required = false) String id, @RequestParam(required = false) String name, @RequestParam(required = false) String kind, @RequestParam(required = false) String quality) {
        ThingSearchRequestDTO searchDTO = new ThingSearchRequestDTO();
        searchDTO.setId(id !=null ? Integer.parseInt(id) : 0);
        searchDTO.setName(name != null ? name : "");
        searchDTO.setKind(kind != null ? kind : "");
        searchDTO.setQuality(quality != null ? quality : "");
        return ResponseEntity.ok(service.findByParams(searchDTO).stream().map(mapper::toResponseDto).toList());
    }
}
