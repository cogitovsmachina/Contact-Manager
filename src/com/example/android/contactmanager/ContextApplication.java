package com.example.android.contactmanager;

import android.app.Application;
import android.content.Context;

public class ContextApplication extends Application {
	private static Context context;

	@Override
	public void onCreate() {
		ContextApplication.context = getApplicationContext();
		super.onCreate();
	}

	public static Context getContext() {
		return context;
	}
}
