package com.sevena.backend.animals;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, String> {
    public Animal findById(String id);
    public List<Animal> findAll();
    public List<Animal> findByName(String name);
}
