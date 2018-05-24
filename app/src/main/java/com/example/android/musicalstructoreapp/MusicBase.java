package com.example.android.musicalstructoreapp;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MusicBase extends AppCompatActivity {
    public ArrayList<Music> musicBase() {
        ArrayList<Music> musicArrayList = new ArrayList<>();

        musicArrayList.add(new Music("Hent I", "EUSA", "Yann Tiersen", R.drawable.eusa, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Pern", "EUSA", "Yann Tiersen", R.drawable.eusa, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Hent II", "EUSA", "Yann Tiersen", R.drawable.eusa, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Ar Maen Bihan", "Infinity", "Yann Tiersen", R.drawable.infinity, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Lights", "Infinity", "Yann Tiersen", R.drawable.infinity, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Gronjord", "Infinity", "Yann Tiersen", R.drawable.infinity, R.drawable.yann_tiersen));
        musicArrayList.add(new Music("Coming for You", "Silent Machine", "Twelve Foot Ninja", R.drawable.silent_machine, R.drawable.twelve_foot_ninja));
        musicArrayList.add(new Music("Kingdom", "Silent Machine", "Twelve Foot Ninja", R.drawable.silent_machine, R.drawable.twelve_foot_ninja));
        musicArrayList.add(new Music("Mother Sky", "Silent Machine", "Twelve Foot Ninja", R.drawable.silent_machine, R.drawable.twelve_foot_ninja));
        musicArrayList.add(new Music("Shuriken", "Silent Machine", "Twelve Foot Ninja", R.drawable.silent_machine, R.drawable.twelve_foot_ninja));
        musicArrayList.add(new Music("Becoming Insane", "Vicious Delicious", "Infected Mushroom", R.drawable.vicious_delicious, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Arillery", "Vicious Delicious", "Infected Mushroom", R.drawable.vicious_delicious, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Vicious Delicious", "Vicious Delicious", "Infected Mushroom", R.drawable.vicious_delicious, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Heavyweight", "Vicious Delicious", "Infected Mushroom", R.drawable.vicious_delicious, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Killing Time", "Legend of the Black Shawarma", "Infected Mushroom", R.drawable.legend_of_the_black_shawarma, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Project 100", "Legend of the Black Shawarma", "Infected Mushroom", R.drawable.legend_of_the_black_shawarma, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Franks", "Legend of the Black Shawarma", "Infected Mushroom", R.drawable.legend_of_the_black_shawarma, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Slowly", "Legend of the Black Shawarma", "Infected Mushroom", R.drawable.legend_of_the_black_shawarma, R.drawable.infected_mushroom));
        musicArrayList.add(new Music("Grace Kelly", "Life in Cartoon Motion", "MIKA", R.drawable.life_in_cartoon_motion, R.drawable.mika));
        musicArrayList.add(new Music("Lollipop", "Life in Cartoon Motion", "MIKA", R.drawable.life_in_cartoon_motion, R.drawable.mika));
        musicArrayList.add(new Music("My Interpretation", "Life in Cartoon Motion", "MIKA", R.drawable.life_in_cartoon_motion, R.drawable.mika));
        musicArrayList.add(new Music("Love Today", "Life in Cartoon Motion", "MIKA", R.drawable.life_in_cartoon_motion, R.drawable.mika));
        musicArrayList.add(new Music("Relax, Take It Easy", "Life in Cartoon Motion", "MIKA", R.drawable.life_in_cartoon_motion, R.drawable.mika));
        musicArrayList.add(new Music("Tressellate", "An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave, R.drawable.alt_j));
        musicArrayList.add(new Music("Breezeblocks", "An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave, R.drawable.alt_j));
        musicArrayList.add(new Music("Interlude 2", "An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave, R.drawable.alt_j));
        musicArrayList.add(new Music("Something Good", "An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave, R.drawable.alt_j));
        musicArrayList.add(new Music("Dissolve Me", "An Awesome Wave", "Alt-J", R.drawable.an_awesome_wave, R.drawable.alt_j));
        musicArrayList.add(new Music("Kids With Guns", "Demon Days", "Gorillaz", R.drawable.demon_days, R.drawable.gorillaz));
        musicArrayList.add(new Music("O Green World", "Demon Days", "Gorillaz", R.drawable.demon_days, R.drawable.gorillaz));
        musicArrayList.add(new Music("Dirty Harry", "Demon Days", "Gorillaz", R.drawable.demon_days, R.drawable.gorillaz));
        musicArrayList.add(new Music("Feel Good Inc.", "Demon Days", "Gorillaz", R.drawable.demon_days, R.drawable.gorillaz));
        musicArrayList.add(new Music("El manana", "Demon Days", "Gorillaz", R.drawable.demon_days, R.drawable.gorillaz));

        return (musicArrayList);
    }
}

