package com.example.retodeezer.model;

import java.io.Serializable;

public class Track implements Serializable {

    private Long id,duration;
    private String title,title_short,link, release_date,preview;
    private Artist artist;
    private Album album;


    public Track(Long id, String title,String title_short, String link, Long duration, String date, String preview, Artist artist, Album album) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.release_date = date;
        this.preview = preview;
        this.artist = artist;
        this.album = album;
        this.title_short = title_short;

    }

    public Track() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


}
