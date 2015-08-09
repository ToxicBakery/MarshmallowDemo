package com.example.ToxicBakery.androidmdemo.data;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

public class FragmentRef {

    @StringRes
    private final int title;
    private final Class<? extends Fragment> fragmentClass;

    public FragmentRef(@StringRes int title, Class<? extends Fragment> fragmentClass) {
        this.title = title;
        this.fragmentClass = fragmentClass;
    }

    @StringRes
    public int getTitle() {
        return title;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

}
