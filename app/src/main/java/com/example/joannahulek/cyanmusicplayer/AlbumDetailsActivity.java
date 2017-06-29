package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;

public class AlbumDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);
        Button playButton = (Button) findViewById(R.id.play_button);
        final Button songsListButton = (Button) findViewById(R.id.songs_list_button);
        final TextView songsListTextView = (TextView) findViewById(R.id.songs_list_text_view);
        final boolean[] isSongsListShown = {false};

        Bundle extras = getIntent().getExtras();
        final Class previousScreen = extras != null ? (Class) extras.get("previousScreen") : null;
        Button backButton = (Button) findViewById(R.id.back_button);

        if (previousScreen == null) {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, MainMenuActivity.class));
        } else {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, previousScreen));
        }


        playButton.setOnClickListener(new OnClickChangeIntentListener(this, NowPlayingActivity.class, getClass()));

        songsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSongsListShown[0]) {
                    songsListTextView.setText(" ");
                    songsListButton.setText("Show");
                    isSongsListShown[0] =false;
                } else {
                    songsListTextView.setText(R.string.pink_floyd_the_wall_songs_list);
                    songsListButton.setText("Hide");
                    isSongsListShown[0] =true;
                }
            }
        });
    }
}