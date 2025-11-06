package com.example.hello_spring.service;

import com.example.hello_spring.model.Thing;
import com.example.hello_spring.model.dto.ThingRequestDTO;
import com.example.hello_spring.model.dto.ThingSearchRequestDTO;
import com.example.hello_spring.repository.ThingRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ThingService {

    private final ThingRepository repository;

    public ThingService(ThingRepository repository) {
        this.repository = repository;
    }

    public Optional<Thing> findById(long id) {
        return repository.findById(id);
    }

    public List<Thing> findByParams(ThingSearchRequestDTO requestDTO) {
        return repository.findByParams(requestDTO.getId(), requestDTO.getName(), requestDTO.getKind(), requestDTO.getQuality());
    }

    public Optional<Thing> save(ThingRequestDTO requestDTO) {
        return repository.save(new Thing(0, requestDTO.getName(), requestDTO.getKind(), Arrays.asList(requestDTO.getQualities())));
    }
}
