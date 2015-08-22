// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            BrightnessSelect, WidgetSettings

public class Widget extends AppWidgetProvider
{

    private static final boolean DEBUG = false;
    private static final String TAG = "Widget";

    public Widget()
    {
    }

    public static RemoteViews buildUpdate(Context context)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030003);
        String s;
        if (android.provider.Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode", -1) == 1)
        {
            s = context.getString(0x7f050005);
        } else
        {
            int i;
            try
            {
                i = android.provider.Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            }
            catch (android.provider.Settings.SettingNotFoundException settingnotfoundexception)
            {
                i = BrightnessSelect.getMaximumBacklight();
            }
            s = toBrightnessPercent(i - 10);
        }
        remoteviews.setOnClickPendingIntent(0x7f08000f, PendingIntent.getActivity(context, 0, new Intent(context, com/curvefish/widgets/brightnesslevel/BrightnessSelect), 0));
        remoteviews.setTextViewText(0x7f080010, s);
        WidgetSettings.updateSettingsButton(context, remoteviews);
        return remoteviews;
    }

    public static Intent getIntent()
    {
        return new Intent("android.settings.DISPLAY_SETTINGS");
    }

    public static void p(String s)
    {
    }

    private static String toBrightnessPercent(int i)
    {
        return (new StringBuilder(String.valueOf(String.valueOf(BrightnessSelect.brightnessToPercent(i))))).append("%").toString();
    }

    static void updateWidgetState(Context context, String s)
    {
        p("updateWidgetState");
        s = buildUpdate(context);
        ComponentName componentname = new ComponentName(context, com/curvefish/widgets/brightnesslevel/Widget);
        AppWidgetManager.getInstance(context).updateAppWidget(componentname, s);
    }

    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if ("android.appwidget.action.APPWIDGET_DELETED".equals(intent.getAction()))
        {
            int i = bundle.getInt("appWidgetId", 0);
            if (i != 0)
            {
                onDeleted(context, new int[] {
                    i
                });
            }
            return;
        } else
        {
            super.onReceive(context, intent);
            p("onReceive");
            return;
        }
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        updateWidgetState(context, "");
        p("onUpdate");
    }
}
