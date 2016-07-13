package com.example.user.starwars.database;

/**
 * Created by user on 13.07.2016.
 */
public class PersonSpecification implements SqlSpecification{

    @Override
    public String toSqlQuery() {
        return String.format(
                "SELECT * FROM " + ItemsTable.TABLE_NAME,null);
    }
}
