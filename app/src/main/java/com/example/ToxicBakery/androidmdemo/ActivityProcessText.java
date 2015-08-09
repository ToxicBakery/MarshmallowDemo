package com.example.ToxicBakery.androidmdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActivityProcessText extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewReceivedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_text);

        textViewReceivedText = (TextView) findViewById(R.id.received_text);

        findViewById(R.id.process_text_done)
                .setOnClickListener(this);

        handleIntent(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_PROCESS_TEXT:
                String text = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT);

                if (text == null) {
                    textViewReceivedText.setText(R.string.process_error_no_text);
                } else {
                    textViewReceivedText.setText(text);
                }

                setIntent(intent);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.process_text_done:
                finish();
                break;
        }
    }

    @Override
    public void finish() {
        Intent intent = getIntent();
        intent.putExtra(Intent.EXTRA_PROCESS_TEXT, textViewReceivedText.getText());
        setResult(Activity.RESULT_OK, intent);

        super.finish();
    }
}
