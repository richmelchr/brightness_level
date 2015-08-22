// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            Help

final class this._cls0 extends TimerTask
{

    final Help this$0;

    public void run()
    {
        Help.access$5(Help.this).sendMessage(Message.obtain(Help.access$5(Help.this)));
    }

    ()
    {
        this$0 = Help.this;
        super();
    }
}
