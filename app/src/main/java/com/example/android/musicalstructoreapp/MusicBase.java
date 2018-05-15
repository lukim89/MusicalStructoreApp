package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MusicBase extends AppCompatActivity {
    public ArrayList<Music> musicBase() {
        ArrayList<Music> musicArrayList = new ArrayList<Music>();

        musicArrayList.add(new Music("tytul1", "album1", "artist11", R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul2", "album1", "artist12",R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul3", "album1", "artist13",R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul4", "album1", "artist14",R.drawable.album_2, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul5", "album1", "artist15",R.drawable.album_2, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul6", "album1", "artist16",R.drawable.album_2, R.drawable.artist_1));

        musicArrayList.add(new Music("tytul7", "album1", "artist17",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul8", "album1", "artist18",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul9", "album1", "artist19",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul10", "album1", "artist10",R.drawable.album_3, R.drawable.artist_2));

        musicArrayList.add(new Music("tytul1", "album2", "artist11",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul2", "album2", "artist12",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul3", "album2", "artist13",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul4", "album2", "artist14",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul5", "album2", "artist15",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul6", "album2", "artist16",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul7", "album2", "artist17",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul8", "album2", "artist18",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul9", "album2", "artist19",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul10", "album2", "artist10",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul1", "album2", "artist11",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul2", "album2", "artist12",R.drawable.album_6, R.drawable.artist_4));

        musicArrayList.add(new Music("tytul3", "album3", "artist13",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul4", "album3", "artist14",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul5", "album3", "artist15",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul6", "album3", "artist16",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul7", "album3", "artist17",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul8", "album3", "artist18",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul9", "album3", "artist19",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul10", "album3", "artist10",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul1", "album3", "artist11",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul2", "album3", "artist12",R.drawable.album_8, R.drawable.artist_5));

        return (musicArrayList);
    }
}

