package com.example.android.musicalstructoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    int playPosition;
    boolean visibility = true;
    boolean isPlay = false;
    MusicBase musicBase = new MusicBase();
    ArrayList<Music> musicBaseList = musicBase.musicBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getTitle().compareTo(music2.getTitle());
                    }
                });
                refresh(0, R.color.colorSecondary);
            }
        });

        TextView album = (TextView) findViewById(R.id.album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getAlbum().compareTo(music2.getAlbum());
                    }
                });
                refresh(1, R.color.colorSecondaryDark);
            }
        });

        final TextView artist = (TextView) findViewById(R.id.artist);
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getArtist().compareTo(music2.getArtist());
                    }
                });
                refresh(2, R.color.colorSecondaryLight);
            }
        });

        ImageView now_cover = (ImageView) findViewById(R.id.now_album_image);
        now_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumIntent);
            }
        });

        ImageView now_artist_image = (ImageView) findViewById(R.id.now_artist_image);
        now_artist_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);

                Bundle extras = new Bundle();
                extras.putString("artistName", musicBaseList.get(playPosition).getArtist());
                extras.putInt("artistImage", musicBaseList.get(playPosition).getImageArtist());
                artistIntent.putExtras(extras);

                startActivity(artistIntent);
            }
        });

        TextView now_title = (TextView) findViewById(R.id.now_title);
        now_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout now = (LinearLayout) findViewById(R.id.now_played);
                if (visibility) {
                    now.setVisibility(View.GONE);
                } else {
                    now.setVisibility(View.VISIBLE);
                }
                visibility = !visibility;
            }
        });


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                setPlayPosition(position);
            }
        });

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playPosition + 1 < musicBaseList.size()) {
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

        final Button playPause = (Button) findViewById(R.id.play_pause);
        playPause.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlay) {
                    playPause.setText("pause");
                } else {
                    playPause.setText("play");
                }
                isPlay = !isPlay;
            }
        });

        refresh(0, R.color.colorSecondary);
        setPlayPosition(playPosition);
    }

    /**
     * This method is setting selected item to "now play".
     */

    public void setPlayPosition(int position) {
        TextView nowTitle = (TextView) findViewById(R.id.now_title);
        nowTitle.setText(musicBaseList.get(position).getTitle());

        TextView nowAlbum = (TextView) findViewById(R.id.now_album);
        nowAlbum.setText(musicBaseList.get(position).getAlbum());

        TextView nowArtist = (TextView) findViewById(R.id.now_artist);
        nowArtist.setText(musicBaseList.get(position).getArtist());

        ImageView imageView = (ImageView) findViewById(R.id.now_album_image);
        imageView.setImageResource(musicBaseList.get(position).getImageAlbum());

        ImageView nowArtistImage = (ImageView) findViewById(R.id.now_artist_image);
        nowArtistImage.setImageResource(musicBaseList.get(position).getImageArtist());

        playPosition = position;
        imageView.setVisibility(View.VISIBLE);
    }

    /**
     * This method refreshing listView depending for sorting type.
     *
     * @param viewType 0 - sort by title, 1 - sort by album, 2 - sort by artist.
     */

    public void refresh(int viewType, int backgroundColor) {
        ListView listView = (ListView) findViewById(R.id.list);
        MusicAdapter adapter =
                new MusicAdapter(this, viewType, musicBaseList, backgroundColor);
        listView.setAdapter(adapter);
    }
}
