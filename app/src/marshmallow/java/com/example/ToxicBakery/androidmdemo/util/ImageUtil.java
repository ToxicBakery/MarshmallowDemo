package com.example.ToxicBakery.androidmdemo.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

public class ImageUtil {

    public static Bitmap circleCrop(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(
                bitmap.getWidth()
                , bitmap.getHeight()
                , Bitmap.Config.ARGB_8888
        );

        final Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        paint.setAntiAlias(true);


        final int smallestDimension = bitmap.getWidth() < bitmap.getHeight() ?
                bitmap.getWidth()
                : bitmap.getHeight();

        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(
                bitmap.getWidth() / 2
                , bitmap.getHeight() / 2
                , smallestDimension / 2, paint
        );

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        final Rect inputRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(bitmap, inputRect, inputRect, paint);

        return output;
    }

}
