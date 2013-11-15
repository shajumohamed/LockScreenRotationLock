package com.example.lockscreenrotator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenStateChangedReceiver extends BroadcastReceiver {
	private boolean screenOff;
	public static String TAG="ScreenStateChangedReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
		{
			screenOff=true;	
			Log.d(TAG,"screenOff="+screenOff);
			
			
		}
		
		if((intent.getAction().equals(Intent.ACTION_SCREEN_ON)))
		{
			screenOff=false;
			Log.d(TAG,"screenOn="+screenOff);
			
			Intent i=new Intent(context,LockChecker.class);
			i.putExtra("screen_state",screenOff);
			context.startService(i);
			Log.d(TAG,"serviceStarted");
		
		}
		
	}

}
