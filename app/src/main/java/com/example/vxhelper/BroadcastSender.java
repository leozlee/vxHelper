package com.example.vxhelper;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class BroadcastSender {

    public static void oneKey(Context context, String username, boolean videoEnable) {
        try {
            // 启动监听
            Intent intent = new Intent(context, WechatCallAs.class);
            intent.putExtra("username", username);
            intent.putExtra("videoEnable", videoEnable);
            context.startService(intent);
            // 打开微信首页
            intent = new Intent();
            ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setComponent(cmp);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // 确保没有微信时不会崩溃
            Toast.makeText(context, "请安装好微信", Toast.LENGTH_SHORT).show();
        }
    }

}
