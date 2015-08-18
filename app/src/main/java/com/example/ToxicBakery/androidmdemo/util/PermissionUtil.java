package com.example.ToxicBakery.androidmdemo.util;

import android.content.Context;
import android.content.pm.PackageManager;

public final class PermissionUtil {

    private PermissionUtil() {
    }

    public static boolean hasAllPermissions(Context context, String[] permissions) {
        for (String permission : permissions) {
            final int result = context.checkSelfPermission(permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

}
