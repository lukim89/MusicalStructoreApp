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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int playPosition;
    boolean nowPlayingVisibility = false;
    boolean isPlaying = false;
    boolean playlistActive = true;
    Music nowSong;
    MusicBase musicBase = new MusicBase();
    List<Music> musicListBase = new ArrayList<>(musicBase.musicBase());
    List<Music> playListBase = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout nowPlaying = findViewById(R.id.now_playing);
        nowPlaying.setVisibility(View.GONE);

        TextView title = findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(musicListBase, new Comparator<Music>() {
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
                Collections.sort(musicListBase, new Comparator<Music>() {
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
                Collections.sort(musicListBase, new Comparator<Music>() {
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
                LinearLayout nowPlaying = findViewById(R.id.now_playing);
                if (nowPlayingVisibility) {
                    nowPlaying.setVisibility(View.GONE);
                } else {
                    nowPlaying.setVisibility(View.VISIBLE);
                }
                nowPlayingVisibility = !nowPlayingVisibility;
            }
        });


        ListView listView = findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (!(playlistActive)) {
                    addToPlaylist(position);
                } else {
                    setPlayPosition(position);
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (playlistActive) {
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
                if (playPosition + 1 < playListBase.size()) {
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
                if (isPlaying) {
                    playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                } else {
                    playPause.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                }
                isPlaying = !isPlaying;
            }
        });

        playListBase = new ArrayList<>();
        playListBase.add(musicListBase.get(1));
        refreshPlaylist();
        setPlayPosition(playPosition);
    }

    public void setPlayPosition(int position) {
        TextView nowTitle = findViewById(R.id.now_title);
        nowTitle.setText(playListBase.get(position).getTitle());

        TextView nowAlbum = findViewById(R.id.now_album);
        nowAlbum.setText(playListBase.get(position).getAlbum());

        TextView nowArtist = findViewById(R.id.now_artist);
        nowArtist.setText(playListBase.get(position).getArtist());

        ImageView imageView = findViewById(R.id.now_album_image);
        imageView.setImageResource(playListBase.get(position).getImageAlbum());

        ImageView nowArtistImage = findViewById(R.id.now_artist_image);
        nowArtistImage.setImageResource(playListBase.get(position).getImageArtist());

        nowSong = playListBase.get(position);

        playPosition = position;
        imageView.setVisibility(View.VISIBLE);
    }

    /**
     * @param viewType 0 - sort by title, 1 - sort by album, 2 - sort by artist.
     */
    public void refresh(int viewType, int backgroundColor) {
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(backgroundColor));
        MusicAdapter adapter =
                new MusicAdapter(this, viewType, (ArrayList<Music>) musicListBase);
        listView.setAdapter(adapter);
    }

    public void refreshPlaylist() {
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
        MusicAdapter adapter =
                new MusicAdapter(this, 0, (ArrayList<Music>) playListBase);
        listView.setAdapter(adapter);
    }

    public void addToPlaylist(int position) {
        playListBase.add(musicListBase.get(position));
        Toast.makeText(this, "Song " + musicListBase.get(position).getTitle() + " added to the playlist.", Toast.LENGTH_SHORT).show();
    }

    public void removeFromPlaylist(int position) {
        if (!(playListBase.size() == 0)) {
            Toast.makeText(this, "Song " + playListBase.get(position).getTitle() + " removed from playlist.", Toast.LENGTH_SHORT).show();
            playListBase.remove(playListBase.get(position));
            refreshPlaylist();
        }
    }
}
