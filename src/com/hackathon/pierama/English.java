package com.hackathon.pierama;

import java.util.ArrayList;

import com.example.moviestop.R;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by shakar on 12/21/14.
 */
public class English extends Fragment {
    public static String which;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        which=getfromdb.drawers;
      //  String []images={R.drawable.ic_launcher};
        ArrayList<Movies> a = getfromdb.english;
		String[] images = new String[a.size()];
		String[] moviename = new String[a.size()];
		String[] releasedate = new String[a.size()];
		String[] genre = new String[a.size()];
		Boolean[] status = new Boolean[a.size()];

		
		try {
			for (int i = 0; i < a.size(); i++) {
				images[i] = a.get(i).getImage();
				moviename[i] = a.get(i).getName();
				Log.d("sfttt", a.get(i).getName());
				releasedate[i] = a.get(i).getRelease_Date();
				genre[i] = a.get(i).getGenre();
				 if (a.get(i).getStatus().equals("1"))
					 status[i]=true;
				 else
					 status[i]=false;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Context context=getActivity();
        View view=inflater.inflate(R.layout.english,container,false);
        //TextView textView=(TextView)view.findViewById(R.id.titlesabc);
        //textView.setText(which);

        GridView gridView= (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new viewadapter(images,moviename,releasedate,genre,status,context));




        return view;
    }
}
