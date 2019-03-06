package com.simon.clipboard;

import android.app.Application;
import android.content.Context;

/**
 * Created by simon on 2017/12/28.
 */

public class AppContext extends Application {
    private static final String TAG = AppContext.class.getName();
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
    }

    public static Context getContext()
    {
        return instance;
    }
}
