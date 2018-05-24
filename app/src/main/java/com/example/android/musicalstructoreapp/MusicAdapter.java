package com.example.android.musicalstructoreapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MusicAdapter extends ArrayAdapter<Music> {

    private int mViewType;

    public MusicAdapter(Activity context, int viewType, ArrayList<Music> music) {
        super(context, 0, music);
        mViewType = viewType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Music currentMusic = getItem(position);

        TextView oneTextView = listItemView.findViewById(R.id.one_text_view);
        TextView twoTextView = listItemView.findViewById(R.id.two_text_view);
        TextView threeTextView = listItemView.findViewById(R.id.three_text_view);
        ImageView imageView = listItemView.findViewById(R.id.image);

        switch (mViewType) {
            case 0:
                oneTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getTitle());
                twoTextView.setText(currentMusic.getAlbum());
                threeTextView.setText(currentMusic.getArtist());
                imageView.setImageResource(currentMusic.getImageAlbum());
                break;

            case 1:
                twoTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getAlbum());
                twoTextView.setText(currentMusic.getTitle());
                threeTextView.setText(currentMusic.getArtist());
                imageView.setImageResource(currentMusic.getImageAlbum());
                break;

            case 2:
                twoTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getArtist());
                twoTextView.setText(currentMusic.getTitle());
                threeTextView.setText(currentMusic.getAlbum());
                imageView.setImageResource(currentMusic.getImageArtist());
                break;
        }
        return listItemView;
    }
}
