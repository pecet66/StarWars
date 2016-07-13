package com.example.user.starwars.database;

/**
 * Created by user on 12.07.2016.
 */
public interface ItemsTable {

    public static final String TABLE_NAME= "Person";

    public interface PersonColumns {

        public static final String NAME = "name";
        public static final String BIRTH_YEAR= "birth_year";
        public static final String EYE_COLOR= "eye_color";
        public static final String HEIGHT= "height";
        public static final String GENDER= "gender";
        public static final String HAIR_COLOR= "hair_color";
        public static final String MASS= "mass";

    }
}
