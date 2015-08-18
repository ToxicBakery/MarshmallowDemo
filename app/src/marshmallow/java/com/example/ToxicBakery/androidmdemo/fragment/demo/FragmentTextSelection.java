package com.example.ToxicBakery.androidmdemo.fragment.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ToxicBakery.androidmdemo.R;

public class FragmentTextSelection extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text_selection, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Bleh", requestCode + " : " + resultCode + " : " + data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
