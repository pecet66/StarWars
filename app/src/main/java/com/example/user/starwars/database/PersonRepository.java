package com.example.user.starwars.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.starwars.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import timber.log.Timber;

/**
 * Created by user on 12.07.2016.
 */
public class PersonRepository implements Repository<Person> {

    private final SQLiteOpenHelper openHelper;

    public PersonRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @Override
    public void add(Person item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<Person> items) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            for (Person item : items) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put(ItemsTable.PersonColumns.NAME, item.getName());
                contentValues.put(ItemsTable.PersonColumns.BIRTH_YEAR, item.getBirthYear());
                contentValues.put(ItemsTable.PersonColumns.GENDER, item.getGender());
                contentValues.put(ItemsTable.PersonColumns.HEIGHT, item.getHeight());
                contentValues.put(ItemsTable.PersonColumns.MASS, item.getMass());
                contentValues.put(ItemsTable.PersonColumns.EYE_COLOR, item.getEyeColor());
                contentValues.put(ItemsTable.PersonColumns.HAIR_COLOR, item.getHairColor());

                try {
                    database.insertOrThrow(ItemsTable.TABLE_NAME, null, contentValues);
                } catch (SQLiteConstraintException e) {
                    Timber.e(e.getMessage());
                }
            }
            database.setTransactionSuccessful();
        }
        catch (SQLiteException ex) {
            Timber.e(ex.toString()); }
        finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void update(Person item) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();
    }

    @Override
    public void remove(Person item) {

    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public List<Person> query(Specification specification) {
        final SqlSpecification sqlSpecification = (SqlSpecification) specification;
        final SQLiteDatabase database = openHelper.getReadableDatabase();
        final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[]{});
        List<Person> items = new ArrayList<Person>();
        database.beginTransaction();

        /*Cursor cursor = database.rawQuery(specification.toSqlString(), new String[] {
                ItemsTable.PersonColumns.NAME,
                ItemsTable.PersonColumns.BIRTH_YEAR,
                ItemsTable.PersonColumns.GENDER,
                ItemsTable.PersonColumns.MASS,
                ItemsTable.PersonColumns.HEIGHT,
                ItemsTable.PersonColumns.EYE_COLOR,
                ItemsTable.PersonColumns.HAIR_COLOR,
        });*/
        while(cursor.moveToNext()) {
            Person person = new Person();
            person.setName((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.BIRTH_YEAR))));
            person.setBirthYear((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.BIRTH_YEAR))));
            person.setGender((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.GENDER))));
            person.setMass((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.MASS))));
            person.setHeight((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.HEIGHT))));
            person.setEyeColor((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.EYE_COLOR))));
            person.setHairColor((cursor.getString(cursor.getColumnIndexOrThrow(ItemsTable.PersonColumns.HAIR_COLOR))));
            items.add(person);
        }
        database.endTransaction();
        database.close();
        return items;
    }
}
