package com.example.timti.androidfriendfinder;

public class AnimalClass {
    /*
    Type
    Breed
    Age
    Picture
    History
    Personality Traits
     */
    public String name;
    public String type;
    public String breed;
    public int age;
    public int photoid;

    public AnimalClass(String name, String type, String breed, int age, int photoid){
        this.name = name;
        this.type = type;
        this.age = age;
        this.photoid = photoid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getPhotoid() {
        return photoid;
    }
}

