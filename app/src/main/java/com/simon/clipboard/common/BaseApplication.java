package com.simon.clipboard.common;

import android.app.Application;

/**
 * @author simon
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance()
    {
        return instance;
    }
}
