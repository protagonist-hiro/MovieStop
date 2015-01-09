package com.hackathon.pierama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CategoryDB extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	static final String DATABASE_NAME = "category.db";
	static final String TABLE_NAME = "category";

	static final String COLUMN_NAME = "Name";
	static final String STATUS = "Status";

	private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
			+ "(_ID INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
			+ " TEXT NOT NULL," + STATUS + " TEXT NOT NULL)";

	public CategoryDB(Context context) {
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
