package com.example.android.musicalstructoreapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Button mGoMain = findViewById(R.id.go_main);
        mGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        int albumImage = bundle.getInt("albumImage");
        String albumName = bundle.getString("albumName", "Album");

        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(albumImage);

        TextView textView = findViewById(R.id.name);
        textView.setTextSize(34);
        textView.setText(albumName);
    }
}

