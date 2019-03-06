package com.simon.clipboard.service;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.simon.clipboard.common.AppContext;
import com.simon.clipboard.util.WindowUtils;

public class ClipboardService extends Service {
    private static final String TAG = ClipboardService.class.getName();

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        final ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        cm.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData data = cm.getPrimaryClip();
                ClipData.Item item = data.getItemAt(0);
                Log.i(TAG, item.getText().toString());
                /*Intent mIntent = new Intent();
                mIntent.setAction("com.cybertron.dict.ClipBoardReceiver");
                mIntent.putExtra("clipboardvalue", item.getText().toString());
                sendBroadcast(mIntent);*/

                WindowUtils.showPopupWindow(AppContext.getContext(), item.getText().toString());
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }
}
