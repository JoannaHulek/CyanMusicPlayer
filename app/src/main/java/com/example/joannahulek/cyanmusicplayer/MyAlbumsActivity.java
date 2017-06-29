package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;

public class MyAlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_albums);

        Button buyMoreButton = (Button) findViewById(R.id.buy_more_button);
        buyMoreButton.setOnClickListener(new OnClickChangeIntentListener(this, BuyNewAlbumActivity.class));

        Bundle extras = getIntent().getExtras();
        final Class previousScreen = extras != null ? (Class) extras.get("previousScreen") : null;
        Button backButton = (Button) findViewById(R.id.back_button);

        if (previousScreen == null) {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, MainMenuActivity.class));
        } else {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, previousScreen));
        }

        TextView artistNameTextView = (TextView) findViewById(R.id.artist_name);
        TextView albumNameTextView = (TextView) findViewById(R.id.album_name);

        artistNameTextView.setOnClickListener(new OnClickChangeIntentListener(this, AlbumDetailsActivity.class, getClass()));
        albumNameTextView.setOnClickListener(new OnClickChangeIntentListener(this, AlbumDetailsActivity.class, getClass()));
    }
}
