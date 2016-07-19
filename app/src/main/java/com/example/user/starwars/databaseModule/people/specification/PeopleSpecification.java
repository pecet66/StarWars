package com.example.user.starwars.databaseModule.people.specification;

import com.example.user.starwars.databaseModule.people.PeopleTable;
import com.example.user.starwars.databaseModule.SqlSpecification;

/**
 * Created by user on 13.07.2016.
 */
public class PeopleSpecification implements SqlSpecification {
    @Override
    public String toSqlQuery() {
        return String.format("SELECT * FROM %s", PeopleTable.TABLE_NAME);
    }
}
