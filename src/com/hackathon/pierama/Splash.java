package com.hackathon.pierama;

import com.example.moviestop.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle Alson) {
		// TODO Auto-generated method stub
		super.onCreate(Alson);
		setContentView(R.layout.splash);
		
		
		Thread timer = new Thread() {
			public void run(){
				try{
					sleep(1600);
				} catch(InterruptedException e){
					e.printStackTrace();

				}finally{
					Intent openStartingPoint = new Intent(Splash.this,next_screen.class);
					startActivity(openStartingPoint);
					
				}
				
			}
			
			
		};
			timer.start();
			
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
			
		
	
	
	
	
}



