package com.dashdeck.app;

import android.content.Context;
import android.content.SharedPreferences;

/** مخزن الإعدادات المحلي المشترك (التصميم، المدينة، إشارات حزام الأمان…). */
final class Prefs {
    private Prefs() { }

    static final String PREFS = "dashdeck";

    static SharedPreferences get(Context c) { return c.getSharedPreferences(PREFS, Context.MODE_PRIVATE); }
}
