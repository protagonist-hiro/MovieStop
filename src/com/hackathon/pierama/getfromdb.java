package com.hackathon.pierama;

import java.util.ArrayList;

import android.database.Cursor;

/**
 * Created by shakar on 12/21/14.
 */
public class getfromdb {
	static String[] columns = { MoviesDB.COLUMN_NAME, MoviesDB.COLUMN_GENRE,
			MoviesDB.RELEASE_DATE, MoviesDB.STATUS, MoviesDB.CATG_ID,
			MoviesDB.IMAGE };
	public static String drawers;
	public static ArrayList<String> data;
	public static ArrayList<Movies> hindi;
	public static ArrayList<Movies> english;
	public static ArrayList<Movies> nepali;
	public static String[] hall = { "QFX Kumari", "QFX Jay Nepal",
			"QFX Civil Mall", "FCUBE", "Kumari" };

	public static String selectedhall;

	public static void get_data() {
		nepali = getNepaliMovies(drawers);
		english = getEnglishMovies(drawers);
		hindi = getHindiMovies(drawers);
	}

	public static void get_data(String selected) {
		// nepali = getNepaliMovies(drawers, selected);
		// english = getEnglishMovies(drawers, selected);
		// hindi = getHindiMovies(drawers, selected);
	}

	public static ArrayList<Movies> getSearchList(String selection) {
		String name;
		String genre;
		String release_Date;
		String image;
		String status;
		Cursor cursor = next_screen.resolver.query(MSProvider.CONTENT_URI,
				columns, selection, null, null);

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

	public static ArrayList<Movies> getNepaliMovies(String category) {
		// Possible values are Recent,Upcoming,Theaters,Mostawaited(all in caps)
		// 1 recent 0 upcoming
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> nepaliMovies = getSearchList("3");
		for (int j = 0; j < nepaliMovies.size(); j++) {

			if (nepaliMovies.get(j).getStatus().equals(category))
				data.add(nepaliMovies.get(j));
		}
		return data;
	}

	public static ArrayList<Movies> getHindiMovies(String category) {
		// return getSearchList("2");
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> hindiMovies = getSearchList("2");
		for (int j = 0; j < hindiMovies.size(); j++) {

			if (hindiMovies.get(j).getStatus().equals(category))
				data.add(hindiMovies.get(j));
		}
		return data;
	}

	public static ArrayList<Movies> getEnglishMovies(String category) {
		// return getSearchList("3");
		ArrayList<Movies> data = new ArrayList<Movies>();
		ArrayList<Movies> englishMovies = getSearchList("1");
		for (int j = 0; j < englishMovies.size(); j++) {

			if (englishMovies.get(j).getStatus().equals(category))
				data.add(englishMovies.get(j));
		}
		return data;
	}
}
