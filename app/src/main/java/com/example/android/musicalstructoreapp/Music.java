package com.example.android.musicalstructoreapp;


public class Music {

    private String mTitle;
    private String mAlbum;
    private String mArtist;
//    private int mCoverImageResourceId;

    public Music(String title, String album, String artist) {
        mTitle = title;
        mAlbum = album;
        mArtist = artist;
//                mCover = cover;
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

//    public int getImage() {
//    return mCoverImageResourceId;
}