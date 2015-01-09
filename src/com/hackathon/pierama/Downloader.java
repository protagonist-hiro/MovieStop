package com.hackathon.pierama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

public class Downloader extends AsyncTask<String, Void, ArrayList<Movies>> {

	JSONParser parser;
	ProgressDialog dialog;
	private ArrayList<Movies> movies;
	String[] Movies_columns = { MoviesDB.COLUMN_NAME, MoviesDB.COLUMN_GENRE,
			MoviesDB.RELEASE_DATE, MoviesDB.STATUS, MoviesDB.CATG_ID,
			MoviesDB.IMAGE };
	String[] Theatre_columns = { TheatreDB.COLUMN_NAME, TheatreDB.HALL_ID,
			TheatreDB.MOVIE_ID, TheatreDB.STATUS };
	String[] Catagory_Table = { CategoryDB.COLUMN_NAME, CategoryDB.STATUS };
	ContentValues value;
	boolean updateFlag;
	private Context context;
	private ArrayList<Theatre> theatre;
	private ArrayList<Category> category;

	public Downloader(Context context) {
		this.context = context;
		updateFlag = TimeCheck.updateFlag(context);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		// Showing ProgressDialog when this AsyncTask executed
		dialog = ProgressDialog.show(context, "Loading JSONOBJECT",
				"Please Wait...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.show();
	}

	@Override
	protected ArrayList<Movies> doInBackground(String... params) {
		for (int i = 0; i < 3; i++) {
			try {
				String data = "";
				HttpClient client = new DefaultHttpClient();
<<<<<<< HEAD

=======
>>>>>>> b713627caef39d80af03effec2efd3d8ce0d8ca3
				HttpGet request = new HttpGet(params[i]);
				HttpResponse response = client.execute(request);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
				String line = "";
				while (line != null) {
					line = reader.readLine();
					data += line;
				}

				parser = new JSONParser();
				switch (i) {
				case 0:
					movies = parser.parseMovies(data);
					break;
				case 1:
					theatre = parser.parseTheatres(data);
					break;
				case 2:
					category = parser.parseCategory(data);
					break;
				}

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movies;
	}

	@Override
	protected void onPostExecute(ArrayList<Movies> result) {
		// TODO Auto-generated method stubs
		super.onPostExecute(result);

		Log.d("OnPostExecute", result.get(0).getName());
		Log.d("OnPostExecute", result.get(1).getName());
		Log.d("OnPostExecute", result.get(2).getName());
		Log.d("OnPostExecute", result.get(3).getName());
		insertValues(result);
		dialog.dismiss();

	}

	private void insertValues(ArrayList<Movies> movies) {
		ContentResolver resolver = next_screen.resolver;
		value = new ContentValues();
		for (int i = 0; i < movies.size(); i++) {
			value.put(Movies_columns[0], movies.get(i).getName());
			value.put(Movies_columns[1], movies.get(i).getGenre());
			value.put(Movies_columns[2], movies.get(i).getRelease_Date());
			value.put(Movies_columns[3], movies.get(i).getStatus());
			value.put(Movies_columns[4], movies.get(i).getCategory_id());
			value.put(Movies_columns[5], movies.get(i).getImage());
			resolver.insert(MSProvider.CONTENT_URI, value);
		}
		Cursor cursor = resolver.query(MSProvider.CONTENT_URI, Movies_columns,
				null, null, null);
		String data = "";
		while (cursor.moveToNext()) {
			data += cursor.getString(0) + "\n";

		}
		Log.d("data", data);/*
							 * Toast.makeText(context, "Movies Inserted",
							 * Toast.LENGTH_LONG).show();
							 * 
							 * for (int i = 0; i < theatre.size(); i++) {
							 * value.put(Theatre_columns[0],
							 * theatre.get(i).getName());
							 * value.put(Theatre_columns[1],
							 * theatre.get(i).getHall_id());
							 * value.put(Theatre_columns[2],
							 * theatre.get(i).getMovie_id());
							 * value.put(Theatre_columns[3],
							 * theatre.get(i).getStatus()); }
							 * 
							 * Toast.makeText(context, "Theatre inserted",
							 * Toast.LENGTH_SHORT).show(); for (int i = 0; i <
							 * category.size(); i++) {
							 * value.put(Catagory_Table[0],
							 * category.get(i).getName());
							 * value.put(Catagory_Table[1],
							 * category.get(i).getStatus()); }
							 * 
							 * Toast.makeText(context, "Catagory inserted",
							 * Toast.LENGTH_SHORT).show(); }
							 */
	}
}
