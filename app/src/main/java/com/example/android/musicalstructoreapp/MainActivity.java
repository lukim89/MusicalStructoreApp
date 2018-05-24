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
    boolean visibility = false;
    boolean isPlay = false;
    boolean playlistActive = false;
    Music nowSong;
    MusicBase musicBase = new MusicBase();
    ArrayList<Music> musicBaseList = musicBase.musicBase();
    ArrayList<Music> playList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout now = findViewById(R.id.now_play);
        now.setVisibility(View.GONE);

        TextView title = findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getTitle().compareTo(music2.getTitle());
                    }
                });
                playlistActive = false;
                refresh(0, R.color.colorSecondary);
            }
        });

        TextView album = findViewById(R.id.album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getAlbum().compareTo(music2.getAlbum());
                    }
                });
                playlistActive = false;
                refresh(1, R.color.colorSecondaryDark);
            }
        });

        TextView artist = findViewById(R.id.artist);
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicBaseList, new Comparator<Music>() {
                    public int compare(Music music1, Music music2) {
                        return music1.getArtist().compareTo(music2.getArtist());
                    }
                });
                playlistActive = false;
                refresh(2, R.color.colorSecondaryLight);
            }
        });

        TextView playlist = findViewById(R.id.playlist);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playlistActive = true;
                refreshPlaylist();
            }
        });

        ImageView now_cover = findViewById(R.id.now_album_image);
        now_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                Bundle extras = new Bundle();
                extras.putString("albumName", nowSong.getAlbum());
                extras.putInt("albumImage", nowSong.getImageAlbum());
                albumIntent.putExtras(extras);
                startActivity(albumIntent);
            }
        });

        ImageView now_artist_image = findViewById(R.id.now_artist_image);
        now_artist_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);

                Bundle extras = new Bundle();
                extras.putString("artistName", nowSong.getArtist());
                extras.putInt("artistImage", nowSong.getImageArtist());
                artistIntent.putExtras(extras);

                startActivity(artistIntent);
            }
        });


        TextView now_title = findViewById(R.id.now_title);
        now_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout nowPlay = findViewById(R.id.now_play);
                if (visibility) {
                    nowPlay.setVisibility(View.GONE);
                } else {
                    nowPlay.setVisibility(View.VISIBLE);
                }
                visibility = !visibility;
            }
        });


        ListView listView = findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (playlistActive == false) {
                    addToPlaylist(position);
                } else {
                    setPlayPosition(position);
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (!(playlistActive == false)) {
                    removeFromPlaylist(position);
                    refreshPlaylist();
                }
                return false;
            }
        });

        ImageView next = findViewById(R.id.next);
        next.setImageResource(R.drawable.ic_skip_next_black_24dp);
        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playPosition + 1 < playList.size()) {
                    playPosition++;
                    setPlayPosition(playPosition);
                }
            }
        });

        ImageView previous = findViewById(R.id.previous);
        previous.setImageResource(R.drawable.ic_skip_previous_black_24dp);
        previous.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(playPosition == 0)) {
                    playPosition--;
                    setPlayPosition(playPosition);
                }
            }
        });

        final ImageView playPause = findViewById(R.id.play_pause);
        playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
        playPause.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlay) {
                    playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                } else {
                    playPause.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                }
                isPlay = !isPlay;
            }
        });


        playList = new ArrayList<>();
        playList.add(musicBaseList.get(1));
        refresh(0, R.color.colorSecondary);
        setPlayPosition(playPosition);
    }


    /**
     * This method is setting selected item to "now play".
     */

    public void setPlayPosition(int position) {
        TextView nowTitle = findViewById(R.id.now_title);
        nowTitle.setText(playList.get(position).getTitle());

        TextView nowAlbum = findViewById(R.id.now_album);
        nowAlbum.setText(playList.get(position).getAlbum());

        TextView nowArtist = findViewById(R.id.now_artist);
        nowArtist.setText(playList.get(position).getArtist());

        ImageView imageView = findViewById(R.id.now_album_image);
        imageView.setImageResource(playList.get(position).getImageAlbum());

        ImageView nowArtistImage = findViewById(R.id.now_artist_image);
        nowArtistImage.setImageResource(playList.get(position).getImageArtist());

        nowSong = playList.get(position);

        playPosition = position;
        imageView.setVisibility(View.VISIBLE);
    }

    /**
     * This method refreshing listView depending for sorting type.
     *
     * @param viewType 0 - sort by title, 1 - sort by album, 2 - sort by artist.
     */

    public void refresh(int viewType, int backgroundColor) {
        ListView listView = findViewById(R.id.list);
        MusicAdapter adapter =
                new MusicAdapter(this, viewType, musicBaseList, backgroundColor);
        listView.setAdapter(adapter);
    }

    public void refreshPlaylist() {
        ListView listView = findViewById(R.id.list);
        MusicAdapter adapter =
                new MusicAdapter(this, 0, playList, R.color.colorPrimaryLight);
        listView.setAdapter(adapter);
    }

    public void addToPlaylist(int position) {
        playList.add(musicBaseList.get(position));
    }

    public void removeFromPlaylist(int position) {
        if (!(playList.size() == 0)) {
            playList.remove(playList.get(position));
            refreshPlaylist();
        }
    }


}
