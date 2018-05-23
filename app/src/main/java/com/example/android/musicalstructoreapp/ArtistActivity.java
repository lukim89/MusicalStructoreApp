package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtistActivity extends AppCompatActivity {

    private Button mGoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        mGoMain = (Button) findViewById(R.id.go_main);

        mGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        int artistImage = bundle.getInt("artistImage");
        String artistName = bundle.getString("artistName", "Artist");

        ImageView imageView = (ImageView) findViewById(R.id.artist_image);
        imageView.setImageResource(artistImage);

        TextView textView = (TextView) findViewById(R.id.artist_name);
        textView.setTextSize(34);
        textView.setText(artistName);
    }
}
