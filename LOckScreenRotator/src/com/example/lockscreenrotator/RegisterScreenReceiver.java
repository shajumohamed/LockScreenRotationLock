package com.example.lockscreenrotator;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

public class RegisterScreenReceiver extends Service {
	public static String TAG = "RegisterScreenReceiver";

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreate() {
		Log.d(TAG, "InsideOnCreate");
		super.onCreate();
	}

	public void onStart(Intent intent, int startId) {
		Log.d(TAG, "InsideonStart");
//		int registered_receiver = 0;
//		SharedPreferences preferences = PreferenceManager
//				.getDefaultSharedPreferences(this);
//		if (preferences.contains("registered_receiver")) {
//			registered_receiver = preferences.getInt("registered_receiver", -1);
//		}
//
//	if (registered_receiver == 0) {
			IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
			filter.addAction(Intent.ACTION_SCREEN_OFF);
			BroadcastReceiver screenStateChangedReceiver = new ScreenStateChangedReceiver();
			registerReceiver(screenStateChangedReceiver, filter);
			Log.d(TAG, "Registration Completed");
//		} else {
//			Log.d(TAG, "Alreay Registered");
//		}
//		SharedPreferences.Editor editor = preferences.edit();
//		editor.putInt("registered_receiver", 1);
//		editor.commit();
	}

}
