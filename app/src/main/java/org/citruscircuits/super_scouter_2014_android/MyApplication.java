package org.citruscircuits.super_scouter_2014_android;


import android.app.Application;
import android.content.Context;

public class MyApplication extends Application
{
	private static Context context;

	public void onCreate()
	{
		super.onCreate();
		MyApplication.context = getApplicationContext();

		// Initialize Parse
		//ParseObject.registerSubclass(Team.class);
		//ParseObject.registerSubclass(Match.class);
		//ParseObject.registerSubclass(Competition.class);
		//Parse.initialize(getApplicationContext(), "gNWwVYFCd9kPDNsarhsjBGRXPv0IB4tA24hyNVzD", "VmitFmcccHzycz1LqVb0BTBsRtFCG1ZyF3cBaeZ1");
	}

	public static Context getAppContext()
	{
		return MyApplication.context;
	}
}
