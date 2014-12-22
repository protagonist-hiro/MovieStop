package com.hackathon.pierama;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MSProvider extends ContentProvider {
	private static final String AUTHORITY = "com.hackathon.pierama.msprovider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/" + MoviesDB.TABLE_NAME);
	private MoviesDB helper;

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues contentValues) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.insert(MoviesDB.TABLE_NAME, null, contentValues);
		return null;
	}

	@Override
	public boolean onCreate() {
		helper = new MoviesDB(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] columns, String selection,
			String[] arg3, String arg4) {
	
		SQLiteDatabase db = helper.getReadableDatabase();

		String WHERE = "";
		if (selection == null)
			WHERE = null;
		else
			WHERE = MoviesDB.CATG_ID + " = '" + selection+"'";
	//	WHERE = MoviesDB.COLUMN_NAME + " = '" + selection+"'";
		return db.query(MoviesDB.TABLE_NAME, columns, WHERE, null, null, null,
				null);
	}

	@Override
	public int update(Uri uri, ContentValues contentValues, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.update(MoviesDB.TABLE_NAME, contentValues, null, null);
		return 0;
	}
}
