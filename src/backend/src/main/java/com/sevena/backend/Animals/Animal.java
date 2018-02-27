package com.sevena.backend.animals;

// Our standard imports
import com.sevena.backend.general.Location;
import com.sevena.backend.general.Properties;

public class Animal {
    private final long id;
    private final String name;
    private final String type;
    private final String desc;
    private final String status;
    private final Location location;
    private final Properties properties;
    private final long shelterId;

    public Animal(long id, String name, String type, String desc,
            String status, Location location, Properties properties,
            long shelterId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.status = status;
        this.location = location;
        this.properties = properties;
        this.shelterId = shelterId;
    }

    public long getId() {
        return id;
    }
}
