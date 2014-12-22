package com.hackathon.pierama;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

/* Pass a JSON String to parse<Field_Name> and it will return arrayList of objects
 * of all the <Fields>. Getter Functions for Theatres object array and Movies Object
 * array are given 
 */

public class JSONParser {
	private ArrayList<Movies> moviesArray;
	private ArrayList<Theatre> theatresArray;
	private ArrayList<Category> categoryArray;

	public ArrayList<Movies> getMovieObject() {
		return this.moviesArray;
	}

	public ArrayList<Theatre> getTheatreArray() {
		return this.theatresArray;
	}

	public ArrayList<Category> getCategoryArray() {
		return this.categoryArray;
	}

	public ArrayList<Movies> parseMovies(String data) throws JSONException {

		JSONArray array = new JSONArray(data);
		moviesArray = new ArrayList<Movies>();
		for (int i = 0; i < array.length(); i++) {
			Movies tmp = new Movies();
			tmp.setName((array.getJSONObject(i).getString("name")));
			tmp.setRelease_Date((array.getJSONObject(i)
					.getString("releaseDate")));
			tmp.setGenre(array.getJSONObject(i).getString("genre"));
			tmp.setStatus(array.getJSONObject(i).getString("status"));
			tmp.setImage(array.getJSONObject(i).getString("image"));
			tmp.setCategory_id((array.getJSONObject(i).getString("category_id")));
			moviesArray.add(tmp);
		}
		return moviesArray;
	}

	public ArrayList<Theatre> parseTheatres(String data) throws JSONException {
		JSONArray array = new JSONArray(data);
		theatresArray = new ArrayList<Theatre>();
		Log.d("I was alive upto ", "inside parseTheatres");

		for (int i = 0; i < array.length(); i++) {
			Theatre tmp = new Theatre();
			tmp.setName(array.getJSONObject(i).getString("name"));
			tmp.setMovie_id(array.getJSONObject(i).getString("movie_id"));
			tmp.setHall_id((array.getJSONObject(i).getString("hall_id")));
			tmp.setStatus(array.getJSONObject(i).getString("status"));

			theatresArray.add(tmp);
		}

		return theatresArray;
	}

	public ArrayList<Category> parseCategory(String data) throws JSONException {
		JSONArray array = new JSONArray(data);
		categoryArray = new ArrayList<Category>();
		for (int i = 0; i < array.length(); i++) {
			Category tmp = new Category();
			tmp.setName((array.getJSONObject(i).getString("Name")));
			tmp.setStatus((array.getJSONObject(i).getString("status")));
			categoryArray.add(tmp);
		}
		return categoryArray;
	}

}
