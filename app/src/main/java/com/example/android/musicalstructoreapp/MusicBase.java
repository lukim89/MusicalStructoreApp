package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MusicBase extends AppCompatActivity {
    public ArrayList<Music> musicBase() {
        ArrayList<Music> musicArrayList = new ArrayList<Music>();

        musicArrayList.add(new Music("tytul1", "album1", "artist1", R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul2", "album1", "artist1",R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul3", "album1", "artist1",R.drawable.album_1, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul4", "album2", "artist1",R.drawable.album_2, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul5", "album2", "artist1",R.drawable.album_2, R.drawable.artist_1));
        musicArrayList.add(new Music("tytul6", "album2", "artist1",R.drawable.album_2, R.drawable.artist_1));

        musicArrayList.add(new Music("tytul7", "album3", "artist2",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul8", "album3", "artist2",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul9", "album3", "artist2",R.drawable.album_3, R.drawable.artist_2));
        musicArrayList.add(new Music("tytul10", "album3", "artist2",R.drawable.album_3, R.drawable.artist_2));

        musicArrayList.add(new Music("tytul1", "album4", "artist3",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul2", "album4", "artist3",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul3", "album4", "artist3",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul4", "album4", "artist3",R.drawable.album_4, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul5", "album5", "artist3",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul6", "album5", "artist3",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul7", "album5", "artist3",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul8", "album5", "artist3",R.drawable.album_5, R.drawable.artist_3));
        musicArrayList.add(new Music("tytul9", "album6", "artist4",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul10", "album6", "artist4",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul1", "album6", "artist4",R.drawable.album_6, R.drawable.artist_4));
        musicArrayList.add(new Music("tytul2", "album6", "artist4",R.drawable.album_6, R.drawable.artist_4));

        musicArrayList.add(new Music("tytul3", "album7", "artist5",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul4", "album7", "artist5",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul5", "album7", "artist5",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul6", "album7", "artist5",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul7", "album7", "artist5",R.drawable.album_7, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul8", "album8", "artist5",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul9", "album8", "artist5",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul10", "album8", "artist5",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul1", "album8", "artist5",R.drawable.album_8, R.drawable.artist_5));
        musicArrayList.add(new Music("tytul2", "album8", "artist5",R.drawable.album_8, R.drawable.artist_5));
        return (musicArrayList);
    }
}

