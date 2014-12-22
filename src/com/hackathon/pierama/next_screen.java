package com.hackathon.pierama;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moviestop.R;

public class next_screen extends ActionBarActivity implements
		AdapterView.OnItemClickListener {
	String[] for_drawer = { "Recent", "Upcoming", "Theatres", "Most Awaited" };
	DrawerLayout drawerlayout;
	boolean firstTime;
	String[] uri = {
			"http://192.168.21.44/YiiProjects/moviestop/json/movie.php",
			"http://192.168.21.44/YiiProjects/moviestop/json/theatre.php",
			"http://192.168.21.44/YiiProjects/moviestop/json/category.php" };

	static ContentResolver resolver;
	ActionBarDrawerToggle drawerListener;
	ViewPager viewPager;
	FragmentManager fragmentManager = getSupportFragmentManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next_screen);

		firstTime = TimeCheck.isFirstTime(this);
		resolver = getContentResolver();

		if (firstTime || TimeCheck.updateFlag(this)) {
			Downloader downloader = new Downloader(this);
			downloader.execute(uri);
		}

		drawerlayout = (DrawerLayout) findViewById(R.id.drawers);
		drawerListener = new ActionBarDrawerToggle(this, drawerlayout,
				R.drawable.bars, R.id.action_bar_activity_content,
				R.id.action_mode_close_button);
		drawerlayout.setDrawerListener(drawerListener);

		ListView listview = (ListView) findViewById(R.id.list);
		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, for_drawer));
		listview.setOnItemClickListener(this);
		viewPager = (ViewPager) findViewById(R.id.pager); // Slide stuffs

		// Slide Stuffs
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().hide();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		drawerlayout.closeDrawers();

		if (i == 0) {
			getfromdb.drawers = "1";
			getfromdb.get_data();
			viewPager.setAdapter(new meroadapter(fragmentManager)); // Slide
																	// stuffs

		}

		else if (i == 1) {

			getfromdb.drawers = "0";
			getfromdb.get_data();
			viewPager.setAdapter(new meroadapter(fragmentManager)); // Slide
																	// stuffs

		}

		else if (i == 2) {
			getfromdb.drawers = "THEATERS";

			showmemyDialog();
			getfromdb.get_data(getfromdb.selectedhall);
			viewPager.setAdapter(new meroadapter(fragmentManager)); // Slide
																	// stuffs
		}

		else if (i == 3) {
			getfromdb.drawers = "MOST AWAITED";
			getfromdb.get_data();
			viewPager.setAdapter(new meroadapter(fragmentManager)); // Slide
																	// stuffs
		}

	}

	private void showmemyDialog() {
		int j = 0;
		Dailog dailog = new Dailog();
		// Dailog_subhall sub_hall=new Dailog_subhall();

		dailog.show(fragmentManager, "first");

	}

}
