package com.hackathon.pierama;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by shakar on 12/21/14.
 */
public class meroadapter extends FragmentPagerAdapter{

    public Fragment fragment=null;


    public meroadapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.d("hello", String.valueOf(i));

        if (i==0)
            fragment = new English();
        else if (i==1)
            fragment=new Hindi();
        else
            fragment=new Nepali();


        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "English";
        else if (position==1)
            return "Hindi";
        else
            return "Nepali";

    }


}
