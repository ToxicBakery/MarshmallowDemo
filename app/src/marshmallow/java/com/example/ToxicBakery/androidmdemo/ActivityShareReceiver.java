package com.example.ToxicBakery.androidmdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class ActivityShareReceiver extends AppCompatActivity {

    public static final String EXTRA_SENDER_NAME = "com.example.ToxicBakery.androidmdemo.EXTRA_SENDER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_receiver);

        TextView textViewTitle = (TextView) findViewById(R.id.share_title);
        TextView textViewContent = (TextView) findViewById(R.id.share_content);

        Bundle bundle = getIntent().getExtras();
        String msg = bundle.getString(Intent.EXTRA_TEXT);
        if (msg == null) {
            throw new IllegalArgumentException("Missing required extra: " + Intent.EXTRA_TEXT);
        }

        textViewTitle.setText(bundle.getString(Intent.EXTRA_TITLE));
        textViewContent.setText(String.format(Locale.ENGLISH, msg, bundle.getString(EXTRA_SENDER_NAME)));

    }

}
