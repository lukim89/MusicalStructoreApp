package com.example.android.musicalstructoreapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MusicAdapter extends ArrayAdapter<Music> {

    private int mViewType;
    private int mColorResourceId;

    public MusicAdapter(Activity context, int viewType, ArrayList<Music> music, int colorResourceId) {
        super(context, 0, music);
        mViewType = viewType;
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Music currentMusic = getItem(position);

        TextView oneTextView = (TextView) listItemView.findViewById(R.id.one_text_view);
        TextView twoTextView = (TextView) listItemView.findViewById(R.id.two_text_view);
        TextView threeTextView = (TextView) listItemView.findViewById(R.id.three_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        View list = listItemView.findViewById(R.id.list);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        switch (mViewType) {
            case 0:
                oneTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getTitle());
                twoTextView.setText(currentMusic.getAlbum());
                threeTextView.setText(currentMusic.getArtist());
                imageView.setImageResource(currentMusic.getImageAlbum());
                list.setBackgroundColor(color);
                break;

            case 1:
                twoTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getAlbum());
                twoTextView.setText(currentMusic.getTitle());
                threeTextView.setText(currentMusic.getArtist());
                imageView.setImageResource(currentMusic.getImageAlbum());
                list.setBackgroundColor(color);
                break;

            case 2:
                twoTextView.setTextSize(34);
                oneTextView.setText(currentMusic.getArtist());
                twoTextView.setText(currentMusic.getTitle());
                threeTextView.setText(currentMusic.getAlbum());
                imageView.setImageResource(currentMusic.getImageArtist());
                list.setBackgroundColor(color);
                break;
        }

        return listItemView;
    }
}
