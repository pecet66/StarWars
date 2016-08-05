package com.example.user.starwars.netModule.model;

/**
 * Created by user on 05.08.2016.
 */
public class PersonNetworkModel {

    public final String name;
    public final String birthYear;
    public final String eyeColor;
    public final String height;
    public final String gender;
    public final String hairColor;
    public final String mass;

    public PersonNetworkModel(String name, String birthYear, String eyeColor, String height, String gender, String hairColor, String mass) {
        this.name = name;
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.height = height;
        this.gender = gender;
        this.hairColor = hairColor;
        this.mass = mass;
    }
}
