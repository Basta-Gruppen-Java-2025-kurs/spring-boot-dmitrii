package com.example.hello_spring.model;

import com.example.hello_spring.model.dto.ThingResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Mapper {
    public ThingResponseDTO toResponseDto(Thing thing) {
        return new ThingResponseDTO() { {
            setId(thing.getId());
            setKind(thing.getKind());
            setName(thing.getName());
            setQualities(thing.getQualities().toArray(new String[0]));
        } };
    }

    public Thing toThing(ThingResponseDTO thingDTO) {
        return new Thing(thingDTO.getId(), thingDTO.getName(), thingDTO.getName(), Arrays.stream(thingDTO.getQualities()).toList());
    }


}
