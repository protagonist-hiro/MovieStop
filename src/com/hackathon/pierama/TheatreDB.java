package com.hackathon.pierama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TheatreDB extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	static final String DATABASE_NAME = "theatre.db";
	static final String TABLE_NAME = "theatre";

	static final String COLUMN_NAME = "Name";
	static final String MOVIE_ID = "Movie_ID";
	static final String STATUS = "Status";
	static final String HALL_ID = "Hall_ID";

	private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
			+ "(_ID INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
			+ " TEXT NOT NULL," + STATUS + " TEXT NOT NULL," + MOVIE_ID
			+ " TEXT NOT NULL," + STATUS + " TEXT NOT NULL," + HALL_ID
			+ " TEXT NOT NULL)";

	public TheatreDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXIST");
		onCreate(db);
	}
}
