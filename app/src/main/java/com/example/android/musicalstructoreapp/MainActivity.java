package com.example.android.musicalstructoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public int playPosition;
    public MusicBase musicBase = new MusicBase();
    final ArrayList<Music> musicBaseList = musicBase.musicBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPlayPosition(playPosition);

        TextView title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent titleIntent = new Intent(MainActivity.this, TitleActivity.class);
                startActivity(titleIntent);
            }
        });

        TextView album = (TextView) findViewById(R.id.album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumIntent);
            }
        });

        TextView artist = (TextView) findViewById(R.id.artist);
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        });


        MusicAdapter adapter =
                new MusicAdapter(this, 0, musicBaseList);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                setPlayPosition(position);
            }
        });

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playPosition+1 < musicBaseList.size()) {
                    playPosition++;
                    setPlayPosition(playPosition);
                }
            }
        });

        Button previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(playPosition == 0)) {
                    playPosition--;
                    setPlayPosition(playPosition);
                }
            }
        });

        }

    /**
     * This method is setting selected item to "now play".
     */

    public void setPlayPosition (int position) {
        TextView nowTitle = (TextView) findViewById(R.id.now_title);
        nowTitle.setText(musicBaseList.get(position).getTitle());

        TextView nowAlbum = (TextView) findViewById(R.id.now_album);
        nowAlbum.setText(musicBaseList.get(position).getAlbum());

        TextView nowArtist = (TextView) findViewById(R.id.now_artist);
        nowArtist.setText(musicBaseList.get(position).getArtist());

        ImageView imageView = (ImageView) findViewById(R.id.now_play);
        imageView.setImageResource(musicBaseList.get(position).getImageAlbum());

        ImageView nowArtistImage = (ImageView) findViewById(R.id.now_artist_image);
        nowArtistImage.setImageResource(musicBaseList.get(position).getImageArtist());

        playPosition = position;
        imageView.setVisibility(View.VISIBLE);
    }
}
