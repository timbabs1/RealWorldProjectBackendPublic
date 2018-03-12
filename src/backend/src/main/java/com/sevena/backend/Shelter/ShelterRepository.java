package com.sevena.backend.shelter;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShelterRepository extends MongoRepository<Shelter, String> {
    public Shelter findById(String id);
    public List<Shelter> findAll();
    public List<Shelter> findByName(String name);
}
