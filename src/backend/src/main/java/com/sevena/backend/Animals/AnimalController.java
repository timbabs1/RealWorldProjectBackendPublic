package com.sevena.backend.animals;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @RequestMapping("/animal")
    public String animal() {
        return "A";//new Animal();
    }
}
