package com.example.retodeezer.model;

import java.io.Serializable;

public class User implements Serializable  {

    private long id;
    private String name, trackList, type;

    public User(long id, String name, String trackList, String type) {
        this.id = id;
        this.name = name;
        this.trackList = trackList;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackList() {
        return trackList;
    }

    public void setTrackList(String trackList) {
        this.trackList = trackList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
