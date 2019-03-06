package com.simon.clipboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.simon.clipboard.R;
import com.simon.clipboard.common.util.LogUtil;
import com.simon.clipboard.service.ClipboardService;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

/**
 * @author simon
 * @date 2019-03-06
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取sd卡写入权限
        AndPermission.with(this)
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(data -> {
                    LogUtil.i(TAG, "用户已授予权限");
                }).onDenied(data -> {
                    LogUtil.i(TAG, "用户拒绝授予权限");
                    Toast.makeText(MainActivity.this, "需要取得权限以使用存储应用数据", Toast.LENGTH_SHORT).show();
                })
                .start();

        //获取悬浮窗权限
        AndPermission.with(this)
                .overlay()
                .onGranted(data -> {
                    Log.i(TAG, "用户已授予悬浮窗权限");
                    Intent intent = new Intent(MainActivity.this, ClipboardService.class);
                    startService(intent);
                })
                .onDenied(data -> {
                    Log.i(TAG, "用户拒绝授予悬浮窗权限");
                    Toast.makeText(MainActivity.this, "需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
                })
                .start();
    }

}
