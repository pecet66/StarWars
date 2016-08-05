package com.example.user.starwars.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by user on 08.07.2016.
 */
public class Person implements Serializable {
    public static final String PERSON_KEY = "Person";
    String name;
    String birthYear;
    String eyeColor;
    String height;
    String gender;
    String hairColor;
    String mass;

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHeight() { return height; }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (birthYear != null ? !birthYear.equals(person.birthYear) : person.birthYear != null)
            return false;
        if (eyeColor != null ? !eyeColor.equals(person.eyeColor) : person.eyeColor != null)
            return false;
        if (height != null ? !height.equals(person.height) : person.height != null) return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (hairColor != null ? !hairColor.equals(person.hairColor) : person.hairColor != null)
            return false;
        return mass != null ? mass.equals(person.mass) : person.mass == null;

    }



    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", height='" + height + '\'' +
                ", gender='" + gender + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", mass='" + mass + '\'' +
                '}';
    }

}