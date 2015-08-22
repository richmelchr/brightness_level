// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            Widget

public class BrightnessSelect extends Activity
{
    class PercentState
    {

        Button b;
        int percent;
        final BrightnessSelect this$0;

        PercentState(int i, int j)
        {
            this$0 = BrightnessSelect.this;
            super();
            percent = i;
            b = (Button)findViewById(j);
            b.setOnClickListener(listener);
        }
    }


    private static final boolean DEBUG = false;
    public static final int MINIMUM_BACKLIGHT = 10;
    public static final int MODE_AUTOMATIC = 1;
    public static final int MODE_MANUAL = 0;
    public static final int MODE_UNSUPPORTED = -1;
    public static final String PREF_BUTTONS_VALUES = "brightness_buttons_values";
    public static final String PREF_CLOSE_ON_SELECT = "brightness_close_on_select";
    public static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
    private static final String TAG = "BrightnessSelectProvider";
    private ArrayList buttons;
    private CheckBox checkBox;
    private int currentBrightness;
    private int defaultPercentValues[];
    private boolean isAutoAvailable;
    private boolean isCloseOnSelect;
    android.view.View.OnClickListener listener;
    public int maxBacklight;
    private int resButtons[] = {
        0x7f080007, 0x7f080008, 0x7f080009, 0x7f08000a, 0x7f08000b
    };
    private ContentResolver resolver;
    private SeekBar sbBrightness;
    private SharedPreferences settings;
    private TextView tvCurrentValue;

    public BrightnessSelect()
    {
        maxBacklight = 255;
        buttons = new ArrayList();
        int ai[] = new int[5];
        ai[1] = 25;
        ai[2] = 50;
        ai[3] = 75;
        ai[4] = 100;
        defaultPercentValues = ai;
        listener = new android.view.View.OnClickListener() {

            final BrightnessSelect this$0;

            public void onClick(View view)
            {
                view.getId();
                JVM INSTR lookupswitch 7: default 72
            //                           16908290: 198
            //                           2131230727: 73
            //                           2131230728: 98
            //                           2131230729: 123
            //                           2131230730: 148
            //                           2131230731: 173
            //                           2131230732: 206;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                return;
_L3:
                updateBrightness(((PercentState)buttons.get(0)).percent);
                return;
_L4:
                updateBrightness(((PercentState)buttons.get(1)).percent);
                return;
_L5:
                updateBrightness(((PercentState)buttons.get(2)).percent);
                return;
_L6:
                updateBrightness(((PercentState)buttons.get(3)).percent);
                return;
_L7:
                updateBrightness(((PercentState)buttons.get(4)).percent);
                return;
_L2:
                finish();
                return;
_L8:
                enableAutoBrightness(true);
                tvCurrentValue.setText(0x7f050005);
                if (isCloseOnSelect)
                {
                    finish();
                    return;
                }
                if (true) goto _L1; else goto _L9
_L9:
            }

            
            {
                this$0 = BrightnessSelect.this;
                super();
            }
        };
    }

    public static int brightnessToPercent(int i)
    {
        if (i == 0)
        {
            return 0;
        }
        if (i == getMaximumBacklight())
        {
            return 100;
        } else
        {
            return Math.round((i * 100) / getMaximumBacklight());
        }
    }

    private void enableAutoBrightness(boolean flag)
    {
        if (flag)
        {
            android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
            layoutparams.screenBrightness = -1F;
            getWindow().setAttributes(layoutparams);
            sbBrightness.setProgress(0);
        }
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        android.provider.Settings.System.putInt(resolver, "screen_brightness_mode", i);
    }

    public static int getMaximumBacklight()
    {
        char c = '\377';
        if (Build.MODEL.toUpperCase().equals("X10I"))
        {
            c = '\376';
        }
        return c - 10;
    }

    private boolean isAutoBrightness()
    {
        return android.provider.Settings.System.getInt(resolver, "screen_brightness_mode", -1) == 1;
    }

    private static void p(String s)
    {
    }

    private void setBrightness(int i)
    {
        if (isAutoAvailable)
        {
            enableAutoBrightness(false);
        }
        currentBrightness = i;
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        float f = (float)i / 100F;
        double d;
        if (f <= 0.08F)
        {
            d = 0.080000000000000002D;
        } else
        {
            d = f;
        }
        layoutparams.screenBrightness = (float)d;
        getWindow().setAttributes(layoutparams);
        tvCurrentValue.setText((new StringBuilder(String.valueOf(i))).append("%").toString());
    }

    private void updateBrightness(int i)
    {
        setBrightness(i);
        sbBrightness.setProgress(i);
        if (isCloseOnSelect)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030002);
        maxBacklight = getMaximumBacklight();
        currentBrightness = maxBacklight;
        resolver = getContentResolver();
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        isCloseOnSelect = settings.getBoolean("brightness_close_on_select", false);
        int i;
        try
        {
            currentBrightness = android.provider.Settings.System.getInt(getContentResolver(), "screen_brightness");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        currentBrightness = currentBrightness - 10;
        currentBrightness = brightnessToPercent(currentBrightness);
        checkBox = (CheckBox)findViewById(0x7f08000e);
        checkBox.setChecked(isCloseOnSelect);
        checkBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final BrightnessSelect this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                isCloseOnSelect = flag;
            }

            
            {
                this$0 = BrightnessSelect.this;
                super();
            }
        });
        findViewById(0x1020002).setOnClickListener(listener);
        findViewById(0x7f080005).setOnClickListener(listener);
        tvCurrentValue = (TextView)findViewById(0x7f080006);
        sbBrightness = (SeekBar)findViewById(0x7f08000d);
        sbBrightness.setMax(100);
        sbBrightness.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final BrightnessSelect this$0;

            public void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                if (flag)
                {
                    setBrightness(j);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (isCloseOnSelect)
                {
                    finish();
                }
            }

            
            {
                this$0 = BrightnessSelect.this;
                super();
            }
        });
        if (android.provider.Settings.System.getInt(resolver, "screen_brightness_mode", -1) == -1)
        {
            isAutoAvailable = false;
            findViewById(0x7f08000c).setVisibility(8);
        } else
        {
            isAutoAvailable = true;
            findViewById(0x7f08000c).setOnClickListener(listener);
        }
        i = 0;
        do
        {
            if (i >= 5)
            {
                tvCurrentValue.setText((new StringBuilder(String.valueOf(currentBrightness))).append("%").toString());
                return;
            }
            buttons.add(new PercentState(defaultPercentValues[i], resButtons[i]));
            i++;
        } while (true);
    }

    public void onDestroy()
    {
        p("onDestroy");
        android.net.Uri uri = android.provider.Settings.System.getUriFor("screen_brightness");
        getContentResolver().notifyChange(uri, null);
        super.onDestroy();
    }

    protected void onPause()
    {
        p("onPause");
        int i = Math.round(((Math.round((currentBrightness * maxBacklight) / 100 + 10) - 10) * 100) / maxBacklight);
        byte byte0 = 0;
        if (i < currentBrightness)
        {
            byte0 = 2;
        }
        int j = (currentBrightness * maxBacklight) / 100 + 10 + byte0;
        p((new StringBuilder("currentBrightness: ")).append(currentBrightness).append(", percent: ").append(i).append(", newBrightness: ").append(byte0).toString());
        p((new StringBuilder("brigtness_final: ")).append(j).toString());
        android.provider.Settings.System.putInt(getContentResolver(), "screen_brightness", j);
        Widget.updateWidgetState(this, "");
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("brightness_close_on_select", isCloseOnSelect);
        editor.commit();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (isAutoAvailable && isAutoBrightness())
        {
            tvCurrentValue.setText(0x7f050005);
            return;
        } else
        {
            sbBrightness.setProgress(currentBrightness);
            return;
        }
    }







}
