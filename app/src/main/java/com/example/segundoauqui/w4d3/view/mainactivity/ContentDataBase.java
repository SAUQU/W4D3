package com.example.segundoauqui.w4d3.view.mainactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.sql.SQLException;

/**
 * Created by segundoauqui on 8/24/17.
 */

public class ContentDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "food";
    private static final String TABLE_NAME = "dishes";
    private static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME +
            " (_id INTEGER PRIMARY KEY, DISHTYPE TEXT , DISHURL TEXT , DISHDESC TEXT, DISHPRICE TEXT )";

    private static final String SQL_DROP = "DROP TABLE IS EXISTS " + TABLE_NAME ;

    ContentDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        onCreate(db);
    }

    public Cursor getImages(String id, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqliteQueryBuilder = new SQLiteQueryBuilder();
        sqliteQueryBuilder.setTables(TABLE_NAME);

        if(id != null) {
            sqliteQueryBuilder.appendWhere("_id" + " = " + id);
        }

        if(sortOrder == null || sortOrder == "") {
            sortOrder = "DISHTYPE";
        }
        Cursor cursor = sqliteQueryBuilder.query(getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        return cursor;
    }

    public long addNewImage(ContentValues values) throws SQLException {
        long id = getWritableDatabase().insert(TABLE_NAME, "", values);
        if(id <=0 ) {
            throw new SQLException("Failed to add an image");
        }

        return id;
    }

    public int deleteImages(String id) {
        if(id == null) {
            return getWritableDatabase().delete(TABLE_NAME, null , null);
        } else {
            return getWritableDatabase().delete(TABLE_NAME, "_id=?", new String[]{id});
        }
    }

    public int updateImages(String id, ContentValues values) {
        if(id == null) {
            return getWritableDatabase().update(TABLE_NAME, values, null, null);
        } else {
            return getWritableDatabase().update(TABLE_NAME, values, "_id=?", new String[]{id});
        }
    }
}



