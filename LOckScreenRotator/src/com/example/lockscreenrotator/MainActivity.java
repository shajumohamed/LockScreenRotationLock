package com.example.lockscreenrotator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	public static String TAG="MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e(TAG, "Main AC Started");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Context context=getBaseContext();
		
		Intent service = new Intent(context, RegisterScreenReceiver.class);
		context.startService(service);
		Log.e(TAG, "service started form MAIN AC");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
