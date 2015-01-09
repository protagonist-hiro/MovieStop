package com.hackathon.pierama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MoviesDB extends SQLiteOpenHelper {

<<<<<<< HEAD
	  static  int DATABASE_VERSION = 1;
=======
	private static final int DATABASE_VERSION = 1;
>>>>>>> b713627caef39d80af03effec2efd3d8ce0d8ca3
	static final String DATABASE_NAME = "movie.db";
	static final String TABLE_NAME = "movie";

	static final String CATG_ID = "Catagoty_ID";
	static final String COLUMN_NAME = "Name";
	static final String COLUMN_GENRE = "Genre";
	static final String RELEASE_DATE = "Release_Date";
	static final String STATUS = "Status";
	static final String IMAGE = "Image";

	private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
			+ "(_ID INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
			+ " TEXT NOT NULL," + COLUMN_GENRE + " TEXT NOT NULL,"
			+ RELEASE_DATE + " TEXT NOT NULL," + STATUS + " TEXT NOT NULL,"
			+ CATG_ID + " TEXT NOT NULL," + IMAGE + " TEXT NOT NULL)";

	public MoviesDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
<<<<<<< HEAD
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
=======
		db.execSQL("DROP TABLE IF EXIST");
>>>>>>> b713627caef39d80af03effec2efd3d8ce0d8ca3
		onCreate(db);
	}
}
