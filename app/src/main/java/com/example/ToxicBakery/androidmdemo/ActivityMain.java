package com.example.ToxicBakery.androidmdemo;

import android.app.assist.AssistContent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ToxicBakery.androidmdemo.fragment.FragmentMenu;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentMenu(), FragmentMenu.TAG)
                .commit();
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        outContent.setWebUri(Uri.parse("http://whatdidtrumpdotoday.com/"));
    }
}
