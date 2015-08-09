package com.example.ToxicBakery.androidmdemo.service;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.util.Log;

import com.example.ToxicBakery.androidmdemo.R;
import com.example.ToxicBakery.androidmdemo.ActivityShareReceiver;
import com.example.ToxicBakery.androidmdemo.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class DirectShareService extends ChooserTargetService {

    private static final String TAG = "DirectShareService";

    private final List<ChooserTarget> targets = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate()");

        targets.add(createTarget("David K.", R.drawable.icon_david, 0.4f));
        targets.add(createTarget("Erin D.", R.drawable.icon_erin, 0.6f));
        targets.add(createTarget("Austin M.", R.drawable.icon_austin, 0.2f));
    }

    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {
        Log.d(TAG, "onGetChooserTargets() " + targets.size());
        return targets;
    }

    private ChooserTarget createTarget(CharSequence name,
                                       @DrawableRes int iconRes,
                                       @FloatRange(from = 0, to = 1) float score) {

        Bitmap bitmapSource = BitmapFactory.decodeResource(getResources(), iconRes);
        Bitmap bitmapCircleCrop = ImageUtil.circleCrop(bitmapSource);

        Intent intent = new Intent(this, ActivityShareReceiver.class);
        Icon icon = Icon.createWithBitmap(bitmapCircleCrop);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        return new ChooserTarget(name, icon, score, pendingIntent);
    }

}
