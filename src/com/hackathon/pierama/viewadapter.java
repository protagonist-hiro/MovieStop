package com.hackathon.pierama;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviestop.R;

/**
 * Created by shakar on 12/21/14.
 */
public class viewadapter extends BaseAdapter {

	ArrayList<Singletext> list;
	Context context;

	class Singletext {
		String imageid;
		String moviename;
		String releasedate;
		String genre;
		Boolean status;

		Singletext(String imageid, String moviename, String releasedate,
				String genre, Boolean status) {
			this.imageid = imageid;
			this.moviename = moviename;
			this.releasedate = releasedate;
			this.genre = genre;
			this.status = status;
		}
	}

	public viewadapter(String Images[], String[] moviename,
			String[] releasedate, String[] genre, Boolean[] Status,
			Context context) {

		list = new ArrayList<Singletext>();
		this.context = context;
		for (int j = 0; j < moviename.length; j++) {
			Singletext s = new Singletext(Images[j], moviename[j],
					releasedate[j], genre[j], Status[j]);
			list.add(s);

		}

	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int i) {
		return list.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		TextView movienaam, genrenaam, releasedatum;
		ImageView imageview;
		CheckBox statuses;
		// int imageid;
		// View views;
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = layoutInflater.inflate(R.layout.eachview, viewGroup, false);
		movienaam = (TextView) view.findViewById(R.id.mn);
		genrenaam = (TextView) view.findViewById(R.id.gn);
		releasedatum = (TextView) view.findViewById(R.id.dates);
		statuses = (CheckBox) view.findViewById(R.id.checkBoxes);
		imageview = (ImageView) view.findViewById(R.id.imageView3);

		MoviesDB mv = new MoviesDB(context);
		SQLiteDatabase db = mv.getReadableDatabase();
		Cursor cursor = db.query(MoviesDB.TABLE_NAME, new String[] {
				MoviesDB.COLUMN_NAME, MoviesDB.IMAGE }, MoviesDB.COLUMN_NAME
				+ " = '" + list.get(i).moviename + "'", null, null, null, null);

		cursor.moveToNext();
		ImageDownloader downloader = new ImageDownloader(imageview);
		downloader.execute("http://192.168.21.44" + cursor.getString(1));
		movienaam.setText(list.get(i).moviename);
		genrenaam.setText(list.get(i).genre);
		releasedatum.setText(list.get(i).releasedate);
		statuses.setChecked(list.get(i).status);
		statuses.setClickable(false);
		// imageview.setImageResource(list.get(i).imageid);

		return view;
	}

}
