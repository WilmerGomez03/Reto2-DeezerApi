package com.example.retodeezer.model;


import java.io.Serializable;

public class PlayList implements Serializable {

    private long id,nb_tracks;
    private String title,description,link,picture, picture_medium;
    private String creation_date;
    private User user;
    private TracksLoader tracks;
    private int fans;

    public PlayList(long id, long nb_tracks, String title, String description, String link, String picture, String picture_medium, String creation_date, User user, TracksLoader tracks,int fans) {

        this.id = id;
        this.nb_tracks = nb_tracks;
        this.title = title;
        this.description = description;
        this.link = link;
        this.picture = picture;
        this.picture_medium = picture_medium;
        this.creation_date = creation_date;
        this.user = user;
        this.tracks = tracks;
        this.fans = fans;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(long nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TracksLoader getTracks() {
        return tracks;
    }

    public void setTracks(TracksLoader tracks) {
        this.tracks = tracks;
    }
    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }
}
