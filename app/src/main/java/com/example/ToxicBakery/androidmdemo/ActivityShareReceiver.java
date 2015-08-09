package com.example.ToxicBakery.androidmdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityShareReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_receiver);

        TextView textViewTitle = (TextView) findViewById(R.id.share_title);
        TextView textViewText = (TextView) findViewById(R.id.share_text);

        Bundle bundle = getIntent().getExtras();
        textViewTitle.setText(bundle.getString(Intent.EXTRA_TITLE));
        textViewText.setText(bundle.getString(Intent.EXTRA_TEXT));
    }

}
