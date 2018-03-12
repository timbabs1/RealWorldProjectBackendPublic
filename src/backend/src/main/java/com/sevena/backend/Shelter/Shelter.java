package com.sevena.backend.shelter;

import java.util.List;
import java.util.Vector;
import java.util.Iterator;

import org.springframework.data.annotation.Id;

import com.sevena.backend.general.Location;
import com.sevena.backend.general.Contact;

import com.sevena.backend.animals.Animal;
import com.sevena.backend.animals.Animals;

public class Shelter {
    @Id
    private final String id;
    
    private final String name;
    private final String desc;
    private final Contact contact;
    private final List<Animal> animals;

    public Shelter(String id, String name, String desc, Contact contact,
            List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.contact = contact;
        this.animals = animals;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Contact getContact() {
        return contact;
    }
    
    // Returns just the IDs.
    public List<String> getAnimals() {
        Animal temp;
        Iterator<Animal> it = animals.iterator();
        List<String> out = new Vector<String>();
        while (it.hasNext()) {
            temp = it.next();
            out.add(temp.getId());
        }
        return out;
    }
}
