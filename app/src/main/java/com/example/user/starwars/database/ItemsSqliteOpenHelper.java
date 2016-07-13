package com.example.user.starwars.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import timber.log.Timber;

/**
 * Created by user on 12.07.2016.
 */
public class ItemsSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StarWars.db";
    public static final int DATABASE_VERSION = 1;

    public ItemsSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Timber.i("Tworze baze");
        sqLiteDatabase.execSQL("CREATE TABLE " + ItemsTable.TABLE_NAME + " (" +
                ItemsTable.PersonColumns.NAME + " TEXT PRIMARY KEY, " +
                ItemsTable.PersonColumns.BIRTH_YEAR + " TEXT, " +
                ItemsTable.PersonColumns.EYE_COLOR + " TEXT, " +
                ItemsTable.PersonColumns.GENDER + " TEXT, " +
                ItemsTable.PersonColumns.HAIR_COLOR + " TEXT, " +
                ItemsTable.PersonColumns.HEIGHT + " TEXT, " +
                ItemsTable.PersonColumns.MASS + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ItemsTable.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
