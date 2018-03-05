package com.sevena.backend.animals;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;

import com.sevena.backend.general.*;

@RestController
public class AnimalController {
    @Autowired
    AnimalRepository repo;

    // Get details on an animal by it's ID.
    @RequestMapping("/animals/{animalid}")
    public ResponseEntity<Animal> animal(@PathVariable("animalid") String animalId) {
        // Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        // Query the Animal.
        Animal found = repo.findById(animalId);
        return new ResponseEntity<Animal>(found, responseHeaders, HttpStatus.CREATED);
    }

    // Search
    @RequestMapping(value="/animals", method = RequestMethod.POST)
    public ResponseEntity<String> searchAnimals() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }
}
