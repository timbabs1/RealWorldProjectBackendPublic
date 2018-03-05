package com.sevena.backend.animals;

// MongoDB requires this.
import org.springframework.data.annotation.Id;

// Our standard imports
import com.sevena.backend.general.Location;
import com.sevena.backend.general.Properties;

public class Animal {
    @Id private final String id;
    private final String name;
    private final String type;
    private final String desc;
    private final String status;
    private final Location location;
    private final Properties properties;
    private final String shelterId;

    public Animal(String id, String name, String type, String desc,
            String status, Location location, Properties properties,
            String shelterId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.status = status;
        this.location = location;
        this.properties = properties;
        this.shelterId = shelterId;
    }
    
    // Damn it Java.... Have to define all the getters....
    public String getId() {
        return id;
    }

    public String getShelter() {
        return shelterId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public Location location() {
        return location;
    }
    
    public Properties getProperties() {
        return properties;
    }
}
