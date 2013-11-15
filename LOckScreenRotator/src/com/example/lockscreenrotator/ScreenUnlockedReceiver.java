package com.example.lockscreenrotator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;

public class ScreenUnlockedReceiver extends BroadcastReceiver {
	public static String TAG = "ScreenUnlockedReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d(TAG, "Unlocked");
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		if (preferences.contains("device_old_rotation")) {
			int device_old_rotation = preferences.getInt("device_old_rotation",
					-1);
			Log.d(TAG, "Read from pref" + device_old_rotation);
			if (preferences.contains("device_unlocked")) {
				int device_unlocked = preferences.getInt("device_unlocked", -1);
				Log.d(TAG, "unlocked value form pref" + device_unlocked);
				if (device_unlocked == 0) {
					if (device_old_rotation != -1) {
						android.provider.Settings.System.putInt(
								context.getContentResolver(),
								Settings.System.ACCELEROMETER_ROTATION,
								device_old_rotation);
					}
				}
			}
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt("device_unlocked", 1);
			editor.commit();
		}
	}

}
