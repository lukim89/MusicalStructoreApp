package com.example.android.musicalstructoreapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumActivity extends AppCompatActivity {

    private Button mGoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        mGoMain = (Button) findViewById(R.id.go_main);

        mGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        int albumImage = bundle.getInt("albumImage");
        String albumName = bundle.getString("albumName", "Album");

        ImageView imageView = (ImageView) findViewById(R.id.album_image);
        imageView.setImageResource(albumImage);

        TextView textView = (TextView) findViewById(R.id.album_name);
        textView.setTextSize(34);
        textView.setText(albumName);
    }
}

