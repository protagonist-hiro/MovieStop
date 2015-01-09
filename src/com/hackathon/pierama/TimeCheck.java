package com.hackathon.pierama;

import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class TimeCheck extends PreferenceActivity {
	private static int day;
	private static int month;
	private static int year;
	private static boolean returnFlag = false;
	private static SharedPreferences.Editor editor;

	public static boolean isFirstTime(Context ctx) {
		int check;
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(ctx);
		check = settings.getInt("firstTime", 0);
		if (check == 42) {
			return false;
		}
		editor = settings.edit();
		editor.putInt("firstTime", 42);
		editor.commit();
		return true;

	}

	public static boolean updateFlag(Context ctx) {
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(ctx);
		returnFlag = checkValid(ctx);
		editor = settings.edit();
		updatePreference(ctx);
		if(returnFlag==true)
				Toast.makeText(ctx,"Datbase Synced", Toast.LENGTH_LONG);
		return returnFlag;

	}

	private static void setTime(Context ctx) {
		Calendar now = Calendar.getInstance();
		day = now.get(Calendar.DAY_OF_MONTH);
		month = now.get(Calendar.MONTH);
		year = now.get(Calendar.YEAR);
	}

	public static void updatePreference(Context ctx) {
<<<<<<< HEAD
        setTime(ctx );
=======

>>>>>>> b713627caef39d80af03effec2efd3d8ce0d8ca3
		editor.putInt("DAY", day);
		editor.putInt("MONTH", month);
		editor.putInt("YEAR", year);
		editor.commit();
	}

	private static boolean checkValid(Context ctx) {
		int oldDay = 0;
		int oldMonth = 0;
		boolean returnValue = false;
		setTime(ctx);
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(ctx);
		oldMonth = preferences.getInt("MONTH", 0);
		oldDay = preferences.getInt("DAY", 0);
		preferences.getInt("DAY", oldDay);
		if (day - oldDay > 3) {
			returnValue = true;
		} else if (month != oldMonth) {
			if (day > 3) {
				returnValue = true;
			}
			
		}
	
		return returnValue;
	}

}
