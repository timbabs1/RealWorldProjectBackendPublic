package com.sevena.backend.general;

public class Properties {
    private final String id;
    
    public Properties(String id) {
        this.id = id;
    }

    public Properties() {
        this.id = "A";
    }

    public String getId() {
        return id;
    }
}
