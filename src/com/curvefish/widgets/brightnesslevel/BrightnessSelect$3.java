// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.widget.SeekBar;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            BrightnessSelect

class this._cls0
    implements android.widget.angeListener
{

    final BrightnessSelect this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            BrightnessSelect.access$6(BrightnessSelect.this, i);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (BrightnessSelect.access$4(BrightnessSelect.this))
        {
            finish();
        }
    }

    ()
    {
        this$0 = BrightnessSelect.this;
        super();
    }
}
