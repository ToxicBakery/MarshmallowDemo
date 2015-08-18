package com.example.ToxicBakery.androidmdemo.fragment.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ToxicBakery.androidmdemo.R;

public class FragmentDirectShare extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_direct_share, container, false);

        view.findViewById(R.id.button_share)
                .setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_share:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.direct_share_msg_title));
                sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.direct_share_msg_content));
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getString(R.string.direct_share_with)));

                break;
        }
    }
}
