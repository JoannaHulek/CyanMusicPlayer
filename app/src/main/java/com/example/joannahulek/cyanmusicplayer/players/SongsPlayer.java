package com.example.joannahulek.cyanmusicplayer.players;

import android.view.View;
import android.widget.ImageView;

import com.example.joannahulek.cyanmusicplayer.R;

/**
 * Created by Joasia on 24.05.2017.
 */

public class SongsPlayer implements SongChanger {

    private String songLocation;
    private boolean isPlayingNow = false;
    private final ImageView playPauseImg;

    public SongsPlayer(String songLocation, ImageView playPauseImg) {
        this.songLocation = songLocation;
        this.playPauseImg = playPauseImg;
    }


    private void play() {
        isPlayingNow = true;
        playPauseImg.setImageResource(R.drawable.pause_icon);

    }

    private void pause() {
        isPlayingNow = false;
        playPauseImg.setImageResource(R.drawable.play_icon);
    }


    @Override
    public View.OnClickListener changeSong(final String sL) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
                songLocation = sL;
                play();
            }
        };
    }


    public View.OnClickListener playPause() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayingNow)
                    pause();
                else
                    play();
            }
        };
    }
}
