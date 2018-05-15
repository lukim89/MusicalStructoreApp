package com.example.android.musicalstructoreapp;


public class Music {

    private String mTitle;
    private String mAlbum;
    private String mArtist;
    private int mAlbumImageResourceId;

    public Music(String title, String album, String artist, int AlbumImageResourceId, int ArtistResourceId) {
        mTitle = title;
        mAlbum = album;
        mArtist = artist;
        mAlbumImageResourceId = AlbumImageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getArtist() {
        return mArtist;
    }


    public int getAlbumImageResourceId() {
        return mAlbumImageResourceId;
    }

}