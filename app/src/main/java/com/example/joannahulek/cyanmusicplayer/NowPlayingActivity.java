package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;
import com.example.joannahulek.cyanmusicplayer.players.SongsPlayer;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        setFunctionalities();


    }

    private void setFunctionalities() {
        TextView albumName = (TextView) findViewById(R.id.album_name);
        ImageView albumImage = (ImageView) findViewById(R.id.album_img);

        ImageView playPauseButton = (ImageView) findViewById(R.id.play_pause_button);
        ImageView nextButton = (ImageView) findViewById(R.id.next_button);
        ImageView previousButton = (ImageView) findViewById(R.id.previous_button);

        final Class previousScreen = (Class) getIntent().getExtras().get("previousScreen");
        Button backButton = (Button) findViewById(R.id.back_button);

        SongsPlayer player = new SongsPlayer("song", playPauseButton);

        if (previousScreen == null) {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, MainMenuActivity.class));
        } else {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, previousScreen));
        }


        albumName.setOnClickListener(new OnClickChangeIntentListener(this, AlbumDetailsActivity.class, getClass()));
        albumImage.setOnClickListener(new OnClickChangeIntentListener(this, AlbumDetailsActivity.class, getClass()));


        playPauseButton.setOnClickListener(player.playPause());
        nextButton.setOnClickListener(player.changeSong("song"));
        previousButton.setOnClickListener(player.changeSong("song"));
    }
}
