package com.example.lockscreenrotator;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;

public class LockChecker extends Service {
	public static String TAG = "LockCheckerService";

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
		boolean screenOff = intent.getBooleanExtra("screen_state", false);
		Log.e(TAG, "screenOff=" + screenOff);
		if (screenOff) {
			// YOUR CODE
		} else {
			KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
			boolean locked = km.isKeyguardLocked();
			Log.e(TAG, "locked=" + locked);
			SharedPreferences preferences = PreferenceManager
					.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = preferences.edit();
			
			if (locked) {
				int currentRotation = android.provider.Settings.System.getInt(
						getContentResolver(),
						Settings.System.ACCELEROMETER_ROTATION, 0);
				Log.e(TAG, "currentRotation=" + currentRotation);

				editor.putInt("device_old_rotation", currentRotation);
				editor.putInt("device_unlocked", 0);

				android.provider.Settings.System.putInt(getContentResolver(),
						Settings.System.ACCELEROMETER_ROTATION, 0);
				Log.e(TAG, "Locked to potrait");
			}
			
			else {
				editor.putInt("device_unlocked", 1);
			}
			
			editor.commit();

		}

	}

}
