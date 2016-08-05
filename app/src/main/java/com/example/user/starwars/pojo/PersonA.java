package com.example.user.starwars.pojo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.gabrielittner.auto.value.cursor.ColumnName;
import com.google.auto.value.AutoValue;

/**
 * Created by user on 05.08.2016.
 */
@AutoValue
public abstract class PersonA implements Parcelable {

    @ColumnName("name")
    abstract String nickname();

    @Nullable
    abstract String birthYear();

    @ColumnName("eye_color")
    abstract String eyeColor();

    abstract String height();

    abstract String gender();

    abstract String hairColor();

    abstract String mass();


    public static Builder builder() {
        return new AutoValue_PersonA.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder nickname(String nickname);

        public abstract Builder birthYear(String birthYear);

        public abstract Builder eyeColor(String eyeColor);

        public abstract Builder height(String height);

        public abstract Builder gender(String gender);

        public abstract Builder hairColor(String hairColor);

        public abstract Builder mass(String mass);

        public abstract PersonA build();
    }


    public static PersonA create(String name, String birthYear, String eyeColor, String height, String gender, String hairColor, String mass) {
        return new AutoValue_PersonA(name, birthYear, eyeColor, height, gender, hairColor, mass);
    }


    public static PersonA create(Cursor cursor) {
        return AutoValue_PersonA.createFromCursor(cursor);
    }

    public abstract ContentValues toContentValues();

    public abstract PersonA withNickname(String name);

}
