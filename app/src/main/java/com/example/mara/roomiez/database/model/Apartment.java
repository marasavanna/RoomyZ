package com.example.mara.roomiez.database.model;

import java.util.List;

/**
 * Created by Akitektuo on 07.03.2018.
 */

public class Apartment {

    //temp int for images so we can use drawables
    public List<Integer> images;
    public String id;
    public int rooms;
    public String adress;
    public float price;
    public String currency;
    public float surface;
    public int bathrooms;
    public int balconies;
    public boolean parking;
    public boolean pets;
    public String description;
    public User owner;

    public Apartment(List<Integer> images, String id, int rooms, String address, float price, String currency, float surface, int bathrooms, int balconies, boolean parking, boolean pets, String description, User owner) {
        this.images = images;
        this.id = id;
        this.rooms = rooms;
        this.adress = address;
        this.price = price;
        this.currency = currency;
        this.surface = surface;
        this.bathrooms = bathrooms;
        this.balconies = balconies;
        this.parking = parking;
        this.pets = pets;
        this.description = description;
        this.owner = owner;
    }

    public Apartment() {
    }

}
