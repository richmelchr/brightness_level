// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.curvefish.widgets.brightnesslevel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;

// Referenced classes of package com.curvefish.widgets.brightnesslevel:
//            Help

public class inflater extends BaseAdapter
    implements android.widget.ClickListener, android.view.er
{

    LayoutInflater inflater;
    int mGalleryItemBackground;
    private Integer mImageIds[] = {
        Integer.valueOf(0x7f020001), Integer.valueOf(0x7f020000), Integer.valueOf(0x7f020015), Integer.valueOf(0x7f020016), Integer.valueOf(0x7f02000b)
    };
    private String mLinks[] = {
        "market://search?q=pname:com.curvefish.apps.appremover", "market://search?q=pname:com.curvefish.apps.appmanager", "market://search?q=pname:com.curvefish.widgets.onoffpack", "market://search?q=pname:com.curvefish.apps.processmanager", "market://search?q=pub:CurveFish"
    };
    private String mTexts[];
    final Help this$0;

    private void updateTimer()
    {
        if (Help.access$3(Help.this) != null)
        {
            Help.access$3(Help.this).cancel();
            Help.access$3(Help.this).purge();
        }
        Help.access$4(Help.this, new Timer());
        Help.access$3(Help.this).scheduleAtFixedRate(new (Help.this), 15000L, 7000L);
    }

    public int getCount()
    {
        return mImageIds.length;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030000, null);
        }
        ((ImageView)viewgroup.findViewById(0x7f080000)).setImageResource(mImageIds[i].intValue());
        ((TextView)viewgroup.findViewById(0x7f080001)).setText(mTexts[i]);
        return viewgroup;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            adapterview = new Intent("android.intent.action.VIEW", Uri.parse(mLinks[i]));
            startActivity(adapterview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            Toast.makeText(Help.this, 0x7f050010, 1).show();
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            updateTimer();
        }
        return false;
    }

    public (Context context)
    {
        this$0 = Help.this;
        super();
        mTexts = (new String[] {
            getString(0x7f05001b), getString(0x7f050018), getString(0x7f05001a), getString(0x7f050019), getString(0x7f05001c)
        });
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
}
