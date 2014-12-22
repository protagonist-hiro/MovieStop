package com.hackathon.pierama;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	String[] columns = { MoviesDB.COLUMN_NAME, MoviesDB.COLUMN_GENRE,
			MoviesDB.RELEASE_DATE, MoviesDB.STATUS, MoviesDB.CATG_ID,
			MoviesDB.IMAGE };
	static ContentResolver resolver;
	String[] uri = { "http://192.168.21.17" };

	ArrayList<Movies> moviesArray;
	ContentValues value;

	String datas;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		resolver = getContentResolver();
		moviesArray = new ArrayList<Movies>();
	}

	public ArrayList<Movies> getSearchList(String selection) {
		String name;
		String genre;
		String release_Date;
		String image;
		String status;
		Cursor cursor = resolver.query(MSProvider.CONTENT_URI, columns,
				selection, null, null);

		ArrayList<Movies> searchedItem = new ArrayList<Movies>();
		while (cursor != null && cursor.moveToNext()) {
			name = cursor.getString(0);
			genre = cursor.getString(1);
			release_Date = cursor.getString(2);
			status = cursor.getString(3);
			image = cursor.getString(4);
			searchedItem.add(new Movies(name, genre, release_Date, status,
					selection, image));
		}
		return searchedItem;
	}

	public ArrayList<Movies> getNepaliMovies(String category) {
		// Possible values are Recent,Upcoming,Theaters,Mostawaited(all in caps)
		// 1 recent 0 upcoming
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> nepaliMovies = getSearchList("1");
		for (int j = 0; j < nepaliMovies.size(); j++) {

			if (nepaliMovies.get(j).getStatus().equals(category))
				data.add(nepaliMovies.get(j));
		}
		return data;
	}

	public ArrayList<Movies> getHindiMovies(String category) {
		// return getSearchList("2");
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> hindiMovies = getSearchList("2");
		for (int j = 0; j < hindiMovies.size(); j++) {

			if (hindiMovies.get(j).getStatus().equals(category))
				data.add(hindiMovies.get(j));
		}
		return data;
	}

	public ArrayList<Movies> getEnglishMovies(String category) {
		// return getSearchList("3");
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> englishMovies = getSearchList("3");
		for (int j = 0; j < englishMovies.size(); j++) {

			if (englishMovies.get(j).getStatus().equals(category))
				data.add(englishMovies.get(j));
		}
		return data;
	}
}
