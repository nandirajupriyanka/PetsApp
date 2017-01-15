package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by priyankanandiraju on 1/14/17.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE pets (" +
                PetContract.PetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PetContract.PetsEntry.COLUMN_PET_NAME + " TEXT NOT NULL," +
                PetContract.PetsEntry.COLUMN_PET_BREED + " TEXT," +
                PetContract.PetsEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL," +
                PetContract.PetsEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + PetContract.PetsEntry.TABLE_NAME;

        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }
}
