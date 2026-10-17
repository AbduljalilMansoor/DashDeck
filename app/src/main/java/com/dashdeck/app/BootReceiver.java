package com.dashdeck.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** عند تشغيل السيارة: أعد تشغيل تنبيه حزام الأمان إن كان مضبوطاً. */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent intent) {
        try { BeltService.sync(ctx); } catch (Exception ignored) { }
    }
}
