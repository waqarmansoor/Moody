package com.microsoft.projectoxford.emotionsample;

/**
 * Created by waqar on 10/14/2016.
 */
public class mysongs {
    String name;
    String mood;
    String genre;
    int song_id;

    mysongs(){}

    mysongs(String name, String mood, String genre, int song_id){
        this.name=name;
        this.genre=genre;
        this.mood=mood;
        this.song_id=song_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
