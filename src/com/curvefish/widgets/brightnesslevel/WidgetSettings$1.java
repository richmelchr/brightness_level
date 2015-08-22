// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            WidgetSettings, Widget

class this._cls0
    implements android.view.ner
{

    final WidgetSettings this$0;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131230740: 
            WidgetSettings.access$0(WidgetSettings.this).setText("");
            return;

        case 2131230741: 
            view = WidgetSettings.access$1(WidgetSettings.this).edit();
            break;
        }
        view.putBoolean("show_label", WidgetSettings.access$2(WidgetSettings.this).isChecked());
        view.putString("label_text", WidgetSettings.access$0(WidgetSettings.this).getText().toString());
        view.commit();
        Widget.updateWidgetState(WidgetSettings.this, "");
        view = new Intent();
        view.putExtra("appWidgetId", WidgetSettings.access$3(WidgetSettings.this));
        setResult(-1, view);
        finish();
    }

    ()
    {
        this$0 = WidgetSettings.this;
        super();
    }
}
