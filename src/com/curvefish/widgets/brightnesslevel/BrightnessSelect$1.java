// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            BrightnessSelect

class this._cls0
    implements android.view.r
{

    final BrightnessSelect this$0;

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 7: default 72
    //                   16908290: 198
    //                   2131230727: 73
    //                   2131230728: 98
    //                   2131230729: 123
    //                   2131230730: 148
    //                   2131230731: 173
    //                   2131230732: 206;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L3:
        BrightnessSelect.access$1(BrightnessSelect.this, ((rcentState)BrightnessSelect.access$0(BrightnessSelect.this).get(0)).percent);
        return;
_L4:
        BrightnessSelect.access$1(BrightnessSelect.this, ((rcentState)BrightnessSelect.access$0(BrightnessSelect.this).get(1)).percent);
        return;
_L5:
        BrightnessSelect.access$1(BrightnessSelect.this, ((rcentState)BrightnessSelect.access$0(BrightnessSelect.this).get(2)).percent);
        return;
_L6:
        BrightnessSelect.access$1(BrightnessSelect.this, ((rcentState)BrightnessSelect.access$0(BrightnessSelect.this).get(3)).percent);
        return;
_L7:
        BrightnessSelect.access$1(BrightnessSelect.this, ((rcentState)BrightnessSelect.access$0(BrightnessSelect.this).get(4)).percent);
        return;
_L2:
        finish();
        return;
_L8:
        BrightnessSelect.access$2(BrightnessSelect.this, true);
        BrightnessSelect.access$3(BrightnessSelect.this).setText(0x7f050005);
        if (BrightnessSelect.access$4(BrightnessSelect.this))
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    rcentState()
    {
        this$0 = BrightnessSelect.this;
        super();
    }
}
