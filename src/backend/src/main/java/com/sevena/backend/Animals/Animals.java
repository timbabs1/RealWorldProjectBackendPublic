package com.sevena.backend.animals;

import java.util.List;
import java.util.Vector;
import java.util.Iterator;

// Our standard imports
import com.sevena.backend.general.Location;
import com.sevena.backend.general.Properties;

// What we return when we have a load of different animals.
public class Animals {
    private final List<Animal> animals;

    public Animals(List<Animal> allAnimals) {
        animals = allAnimals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getCount() {
        return animals.size();
    }
}
