package com.example.musicPlaylist;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(String title,String artist,String album,int duration){
        this.title=title;
        this.album=album;
        this.artist=artist;
        this.duration=duration;
    }

    @Override
    public String toString(){
        return "Title: "+title+", Artist: "+artist+", Album: "+album+", Duration: "+duration+" seconds";
    }

    public String toCsvRow(){
        return title+","+artist+","+album+","+duration;
    }
}