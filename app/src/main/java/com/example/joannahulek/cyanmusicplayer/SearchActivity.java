package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle extras = getIntent().getExtras();
        final Class previousScreen = extras != null ? (Class) extras.get("previousScreen") : null;

        Button myAlbumsButton = (Button) findViewById(R.id.my_albums_button);
        myAlbumsButton.setOnClickListener(new OnClickChangeIntentListener(this, MyAlbumsActivity.class));


        Button backButton = (Button) findViewById(R.id.back_button);

        if (previousScreen == null) {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, MainMenuActivity.class));
        } else {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, previousScreen));
        }

    }
}
