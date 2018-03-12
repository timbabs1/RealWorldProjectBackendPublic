package com.sevena.backend.animals;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;

import com.sevena.backend.general.*;

@RestController
public class AnimalController {
    @Autowired
    AnimalRepository repo;

    /* Get details on an animal by it's ID. */
    @RequestMapping(value={"/animals/{animalid}","/animals"})
    public ResponseEntity<?> animal(
            @PathVariable(name="animalid", required=false) String animalId) {
        List<Animal> animalsRaw;
        Animal animalFound;
        Animals animalsFound;

        HttpHeaders responseHeaders = new HttpHeaders();
        
        if (animalId != null) {
            animalFound = repo.findById(animalId);
            return new ResponseEntity<Animal>(animalFound, responseHeaders,
                    HttpStatus.OK);
        } else {
            animalsRaw = repo.findAll();
            animalsFound = new Animals(animalsRaw);
            return new ResponseEntity<Animals>(animalsFound, responseHeaders,
                    HttpStatus.OK);
        }
    }
    
    /* Create a new animal. */
    @RequestMapping(value="/animals", method = RequestMethod.POST)
    public ResponseEntity<String> addAnimal(@RequestBody Animal newAnimal) {
        HttpHeaders responseHeaders = new HttpHeaders();
        repo.insert(newAnimal);
        return new ResponseEntity<String>("Hello World", responseHeaders, 
                HttpStatus.CREATED);
    }

    /* Search the animals. */
    @RequestMapping(value="/animals/search", method = RequestMethod.GET)
    public ResponseEntity<String> searchAnimal() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>("Hello World", responseHeaders, 
                HttpStatus.CREATED);
    }
}
