package com.example.hello_spring.service;

import com.example.hello_spring.model.Thing;
import com.example.hello_spring.repository.ThingRepository;
import org.springframework.stereotype.Service;

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
}
