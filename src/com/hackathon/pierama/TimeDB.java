package com.hackathon.pierama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeDB extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	static final String DATABASE_NAME = "time.db";
	static final String TABLE_NAME = "time";

	static final String Movie_ID = "Movie_ID";
	static final String HALL_ID = "Hall_ID";
	static final String START = "startTime";
	static final String END = "endTime";
	static final String STATUS = "Status";

	private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
			+ "(_ID INTEGER PRIMARY KEY AUTOINCREMENT," + Movie_ID
			+ " TEXT NOT NULL," + HALL_ID + " TEXT NOT NULL," + START
			+ " TEXT NOT NULL," + END + " TEXT NOT NULL," + STATUS
			+ " TEXT NOT NULL)";

	public TimeDB(Context context) {
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
