// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            WidgetSettings

class this._cls0
    implements android.widget.CheckedChangeListener
{

    final WidgetSettings this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        WidgetSettings.access$4(WidgetSettings.this, "show_label", flag);
        WidgetSettings.access$0(WidgetSettings.this).setEnabled(flag);
        WidgetSettings.access$5(WidgetSettings.this).setEnabled(flag);
        if (flag)
        {
            WidgetSettings.access$0(WidgetSettings.this).setInputType(1);
            return;
        } else
        {
            WidgetSettings.access$0(WidgetSettings.this).setInputType(0);
            return;
        }
    }

    ()
    {
        this$0 = WidgetSettings.this;
        super();
    }
}
