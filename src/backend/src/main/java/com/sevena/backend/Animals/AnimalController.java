package com.sevena.backend.animals;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    // Get details on an animal by it's ID.
    @RequestMapping("/animals/{animalid}")
    public ResponseEntity<String> animal(@PathVariable("animalid") String animalId) {
        HttpHeaders responseHeaders = new HttpHeaders();
        System.out.println(animalId);
        return new ResponseEntity<String>("HELLO WORLD", responseHeaders, HttpStatus.CREATED);
    }

    // Search
    @RequestMapping(value="/animals", method = RequestMethod.POST)
    public ResponseEntity<String> searchAnimals() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }
}
