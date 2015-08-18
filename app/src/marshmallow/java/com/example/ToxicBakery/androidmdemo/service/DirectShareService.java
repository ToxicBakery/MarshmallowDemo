package com.example.ToxicBakery.androidmdemo.service;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ToxicBakery.androidmdemo.ActivityShareReceiver;
import com.example.ToxicBakery.androidmdemo.R;
import com.example.ToxicBakery.androidmdemo.util.ImageUtil;

import java.util.LinkedList;
import java.util.List;

public class DirectShareService extends ChooserTargetService {

    private static final String TAG = "DirectShareService";

    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {
        Log.d(TAG, "onGetChooserTargets()");

        final List<ChooserTarget> targets = new LinkedList<>();
        targets.add(createTarget("David K.", R.drawable.icon_david, 0.4f));
        targets.add(createTarget("Erin D.", R.drawable.icon_erin, 0.6f));
        targets.add(createTarget("Austin M.", R.drawable.icon_austin, 0.2f));

        return targets;
    }

    private ChooserTarget createTarget(@NonNull String name,
                                       @DrawableRes int iconRes,
                                       @FloatRange(from = 0, to = 1) float score) {

        Bitmap bitmapSource = BitmapFactory.decodeResource(getResources(), iconRes);
        Bitmap bitmapCircleCrop = ImageUtil.circleCrop(bitmapSource);

        Icon icon = Icon.createWithBitmap(bitmapCircleCrop);
        ComponentName componentName = new ComponentName(this, ActivityShareReceiver.class);

        Bundle bundle = new Bundle();
        bundle.putString(ActivityShareReceiver.EXTRA_SENDER_NAME, name);

        return new ChooserTarget(name, icon, score, componentName, bundle);
    }

}
