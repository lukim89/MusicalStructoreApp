package com.example.android.musicalstructoreapp;


public class Music {

    private String mTitle;
    private String mAlbum;
    private String mArtist;
    private int mAlbumImageResourceId;
    private int mArtistImageResourceId;

    public Music(String title, String album, String artist, int AlbumImageResourceId, int ArtistImageResourceId) {
        mTitle = title;
        mAlbum = album;
        mArtist = artist;
        mAlbumImageResourceId = AlbumImageResourceId;
        mArtistImageResourceId = ArtistImageResourceId;
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

    public int getImageAlbum() {
        return mAlbumImageResourceId;
    }

    public int getImageArtist() {
        return mArtistImageResourceId;
    }
}