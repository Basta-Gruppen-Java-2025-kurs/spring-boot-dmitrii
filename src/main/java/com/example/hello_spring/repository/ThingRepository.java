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

    public List<Thing> findByParams(long id, String name, String kind, String quality) {
        return things.stream()
                .filter(th ->
                (id <= 0 || th.getId() == id) &&
                (name.isBlank() || th.getName().toLowerCase().contains(name.toLowerCase())) &&
                (kind.isBlank() || th.getKind().toLowerCase().contains(kind.toLowerCase())) &&
                (quality.isBlank() || th.getQualities().stream().anyMatch(q -> q.toLowerCase().contains(quality.toLowerCase()))))
                .toList();
    }

    private long getMaxIndex() {
        return things.stream().map(Thing::getId).max(Long::compare).orElse(0L);
    }

    public Optional<Thing> save(Thing thing) {
        thing.setId(getMaxIndex() + 1);
        things.add(thing);
        return Optional.of(thing);
    }
}
