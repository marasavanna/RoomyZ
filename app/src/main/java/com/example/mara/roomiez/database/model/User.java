package com.example.mara.roomiez.database.model;

/**
 * Created by AoD Akitektuo on 01-Mar-18 at 17:08.
 */

public class User {

    public String name;
    public String email;
    public int age;
    public String image;
    public String id;

    public User(){}

    public User(String name, String email, int age, String image, String id) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.image = image;
        this.id = id;
    }

}
