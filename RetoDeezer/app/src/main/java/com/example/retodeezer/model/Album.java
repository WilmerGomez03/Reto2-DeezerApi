package com.example.retodeezer.model;

import java.io.Serializable;

public class Album implements Serializable {

    private Long id;
    private String title,cover, cover_medium,release_date;

    public Album(Long id, String title, String cover, String cover_medium, String release_date) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.cover_medium = cover_medium;
        this.release_date = release_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_medium() {
        return cover_medium;
    }

    public void setCover_medium(String cover_medium) {
        this.cover_medium = cover_medium;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
