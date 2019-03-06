package com.simon.clipboard;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.simon.clipboard.service.ClipboardService;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndPermission.with(this)
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (Settings.canDrawOverlays(MainActivity.this)) {
                                Intent intent = new Intent(MainActivity.this, ClipboardService.class);
                                startService(intent);
                            } else {
                                //若没有权限，提示获取.
                                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                                Toast.makeText(MainActivity.this, "需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                            }
                        } else {
                            //SDK在23以下，不用管.
                            Intent intent = new Intent(MainActivity.this, ClipboardService.class);
                            startService(intent);
                        }
                    }
                }).onDenied(new Action<List<String>>() {
            @Override
            public void onAction(List<String> data) {

            }
        }).start();

    }
}
