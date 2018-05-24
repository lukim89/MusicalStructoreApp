package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ArtistActivity extends AppCompatActivity {

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

        int artistImage = bundle.getInt("artistImage");
        String artistName = bundle.getString("artistName", "Artist");

        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(artistImage);

        TextView textView = findViewById(R.id.name);
        textView.setTextSize(34);
        textView.setText(artistName);
    }
}
