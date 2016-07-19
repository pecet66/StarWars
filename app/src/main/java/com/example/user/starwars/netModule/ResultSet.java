package com.example.user.starwars.netModule;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by user on 11.07.2016.
 */
public class ResultSet<T> {

    String count;
    List<T> results;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}

