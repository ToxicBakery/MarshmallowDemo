package com.example.ToxicBakery.androidmdemo;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivitySearch extends AppCompatActivity {

    private static final String SEARCH_ACTION = "com.google.android.gms.actions.SEARCH_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView query = (TextView) findViewById(R.id.search_query);

        if (SEARCH_ACTION.equals(getIntent().getAction())) {
            query.setText(getIntent().getStringExtra(SearchManager.QUERY));
        } else {
            query.setText(R.string.search_no_query);
        }
    }

}
