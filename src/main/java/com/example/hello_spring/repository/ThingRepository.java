package com.example.hello_spring.repository;

import com.example.hello_spring.model.Thing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ThingRepository {
    final List<Thing> things = new ArrayList<>();

    public ThingRepository() {
        things.add(new Thing(1, "TV", "home appliance", new ArrayList<>(Arrays.asList("Big", "Bright", "Electric"))));
        things.add(new Thing(2, "Cat", "pet", new ArrayList<>(Arrays.asList("Furry", "Funny", "Carnivorous"))));
        things.add(new Thing(3, "Bulldozer", "machine", new ArrayList<>(Arrays.asList("Heavy", "Durable", "Metal"))));
        things.add(new Thing(4, "Atom", "particle", new ArrayList<>(Arrays.asList("Tiny", "Quantum", "Basic"))));
        things.add(new Thing(5, "Question", "figure of speech", new ArrayList<>(Arrays.asList("Dubious", "Curious", "Enigmatic"))));
    }

    public Optional<Thing> findById(long id) {
        return things.stream().filter(t -> t.getId() == id).findFirst();
    }
}
