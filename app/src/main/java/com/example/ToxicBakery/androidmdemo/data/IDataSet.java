package com.example.ToxicBakery.androidmdemo.data;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

public interface IDataSet {

    @NonNull
    FragmentRef getItemClass(@IntRange(from = 0) int position);

    @IntRange(from = 0)
    int count();

    interface IOnFragmentRefSelectedListener {

        void onFragmentRefSelected(@NonNull FragmentRef fragmentRef);

    }
}
