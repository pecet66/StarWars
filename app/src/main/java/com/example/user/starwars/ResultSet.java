package com.example.user.starwars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.07.2016.
 */
public class ResultSet {

    String count;
    ArrayList<Person> results;

    public ResultSet(ArrayList<Person> result) {
        this.results = result;
    }

    public String getCount() {
        return count;
    }

    public ArrayList<Person> getResult() {
        return results;
    }

    public ArrayList<Person> getResults() {
        return results;
    }
}
