package com.example.joannahulek.cyanmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joannahulek.cyanmusicplayer.listeners.OnClickChangeIntentListener;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.Simplify;

import static android.R.attr.visible;
import static android.view.View.VISIBLE;

public class BuyNewAlbumActivity extends AppCompatActivity {

    Simplify simplify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        simplify = new Simplify();
        simplify.setApiKey("sbpb_OTljZWQ5ZjMtZmFhNS00ZTUxLTlhMjUtZWYwYmZhY2NmMWNk");

        setContentView(R.layout.activity_buy_new_album);

        final Class previousScreen = (Class) getIntent().getExtras().get("previousScreen");
        Button backButton = (Button) findViewById(R.id.back_button);

        if (previousScreen == null) {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, MainMenuActivity.class));
        } else {
            backButton.setOnClickListener(new OnClickChangeIntentListener(this, previousScreen));
        }

        Button buyAlbum = (Button) findViewById(R.id.buy_album);
        final CardEditor cardEditorView = (CardEditor) findViewById(R.id.card_editor);

        buyAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardEditorView.setVisibility(VISIBLE);
            }
        });


    }


}
