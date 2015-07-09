package org.citruscircuits.super_scouter_2014_android;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Toaster
{
	public static void makeToast(String text, int length)
	{
		Toast toast = Toast.makeText(MyApplication.getAppContext(), text, length);
		toast.show();	
		
		Log.e("stupid logcat", "Info toast: " + text);
	}

	public static void makeErrorToast(String text, int length)
	{
		Toast toast = Toast.makeText(MyApplication.getAppContext(), text, length);
		TextView textVew = (TextView) toast.getView().findViewById(android.R.id.message);
		textVew.setTextColor(Color.RED);
		toast.show();
		
		Log.e("stupid logcat", "Error toast: " + text);
	}

	public static void makeToastOnMainThread(final String text, final int length, final Activity context)
	{
		context.runOnUiThread(new Runnable()
		{
			
			@Override
			public void run()
			{
				makeToast(text, length);
			}
		});

	}
	
	public static void makeErrorToastOnMainThread(final String text, final int length, final Activity context)
	{
		context.runOnUiThread(new Runnable()
		{
			
			@Override
			public void run()
			{
				makeErrorToast(text, length);
			}
		});

	}
}
