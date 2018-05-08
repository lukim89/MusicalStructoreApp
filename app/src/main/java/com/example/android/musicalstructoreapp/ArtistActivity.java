package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        MusicBase musicBase = new MusicBase();
        ArrayList<Music> musicBaseList = musicBase.musicBase();

        Collections.sort(musicBaseList, new Comparator<Music>() {
            @Override
            public int compare(Music music1, Music music2) {
                return music1.getArtist().compareTo(music2.getArtist());
            }
        });

        MusicAdapter adapter =
                new MusicAdapter(this, musicBaseList);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
