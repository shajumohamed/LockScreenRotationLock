package com.example.lockscreenrotator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiveraaa extends BroadcastReceiver {
	public static String TAG="BootReceiveraaa";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		Intent service = new Intent(context, RegisterScreenReceiver.class);
		context.startService(service);
		Log.e(TAG, "*********service started form BootReceiver");
	}

}
