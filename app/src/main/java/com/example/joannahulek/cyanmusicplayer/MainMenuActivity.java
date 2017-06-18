package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button nowPlayingButton = (Button) findViewById(R.id.now_playing_button);
        Button myAlbumsButton = (Button) findViewById(R.id.my_albums_button);
        Button searchButton = (Button) findViewById(R.id.search_button);
        Button buyButton = (Button) findViewById(R.id.buy_new_album_button);

        nowPlayingButton.setOnClickListener(getListenerForNewScreen(NowPlayingActivity.class));

        myAlbumsButton.setOnClickListener(getListenerForNewScreen(MyAlbumsActivity.class));

        searchButton.setOnClickListener(getListenerForNewScreen(SearchActivity.class));

        buyButton.setOnClickListener(getListenerForNewScreen(BuyNewAlbumActivity.class));


    }

    private OnClickChangeIntentListener getListenerForNewScreen(Class ClassName) {
        return new OnClickChangeIntentListener(this, ClassName, getClass());
    }
}
