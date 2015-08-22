// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.os.Handler;
import android.os.Message;
import android.widget.Gallery;
import java.util.Random;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            Help

class this._cls0 extends Handler
{

    final Help this$0;

    public void handleMessage(Message message)
    {
        Help.access$0(Help.this).setSelection(Help.access$1(Help.this).nextInt(Help.access$2(Help.this).getCount()));
    }

    ageAdapter()
    {
        this$0 = Help.this;
        super();
    }
}
