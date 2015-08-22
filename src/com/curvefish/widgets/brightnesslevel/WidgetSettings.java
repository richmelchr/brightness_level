// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            Widget

public class WidgetSettings extends Activity
{

    public static final String LABEL_TEXT = "label_text";
    public static final String SETTINGS = "widget_settings";
    public static final String SHOW_LABEL = "show_label";
    private Button bClear;
    private CheckBox cbLabel;
    private EditText etLabel;
    android.view.View.OnClickListener listener;
    private int mAppWidgetId;
    private SharedPreferences settings;

    public WidgetSettings()
    {
        listener = new android.view.View.OnClickListener() {

            final WidgetSettings this$0;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131230740: 
                    etLabel.setText("");
                    return;

                case 2131230741: 
                    view = settings.edit();
                    break;
                }
                view.putBoolean("show_label", cbLabel.isChecked());
                view.putString("label_text", etLabel.getText().toString());
                view.commit();
                Widget.updateWidgetState(WidgetSettings.this, "");
                view = new Intent();
                view.putExtra("appWidgetId", mAppWidgetId);
                setResult(-1, view);
                finish();
            }

            
            {
                this$0 = WidgetSettings.this;
                super();
            }
        };
    }

    private void saveSettings(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(s, flag);
        editor.commit();
    }

    static void updateSettingsButton(Context context, RemoteViews remoteviews)
    {
        Object obj = context.getSharedPreferences("widget_settings", 0);
        if (((SharedPreferences) (obj)).getBoolean("show_label", true))
        {
            remoteviews.setOnClickPendingIntent(0x7f080011, PendingIntent.getActivity(context, 0, Widget.getIntent(), 0));
            remoteviews.setTextViewText(0x7f080001, context.getText(0x7f05000d));
            obj = ((SharedPreferences) (obj)).getString("label_text", "");
            if (!((String) (obj)).equals(""))
            {
                remoteviews.setTextViewText(0x7f080001, ((CharSequence) (obj)));
                return;
            } else
            {
                remoteviews.setTextViewText(0x7f080001, context.getString(0x7f05000e));
                return;
            }
        } else
        {
            remoteviews.setViewVisibility(0x7f080001, 4);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030004);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            mAppWidgetId = bundle.getInt("appWidgetId", 0);
        }
        if (mAppWidgetId == 0)
        {
            finish();
        }
        ((TextView)findViewById(0x7f080004)).setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(0x7f080015).setOnClickListener(listener);
        settings = getSharedPreferences("widget_settings", 0);
        cbLabel = (CheckBox)findViewById(0x7f080012);
        cbLabel.setChecked(settings.getBoolean("show_label", true));
        cbLabel.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final WidgetSettings this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                saveSettings("show_label", flag);
                etLabel.setEnabled(flag);
                bClear.setEnabled(flag);
                if (flag)
                {
                    etLabel.setInputType(1);
                    return;
                } else
                {
                    etLabel.setInputType(0);
                    return;
                }
            }

            
            {
                this$0 = WidgetSettings.this;
                super();
            }
        });
        bClear = (Button)findViewById(0x7f080014);
        bClear.setOnClickListener(listener);
        bClear.setEnabled(cbLabel.isChecked());
        etLabel = (EditText)findViewById(0x7f080013);
        bundle = getString(0x7f05000e);
        String s = settings.getString("label_text", bundle);
        if (s.equals(""))
        {
            etLabel.setText(bundle);
        } else
        {
            etLabel.setText(s);
        }
        if (!cbLabel.isChecked())
        {
            etLabel.setEnabled(false);
            etLabel.setInputType(0);
        }
    }






}
