package com.example.retodeezer.model;

public class PlayListsLoader {

    private PlayList[] data;


    public PlayListsLoader(PlayList[] data) {
        this.data = data;

    }

    public PlayList[] getData() {
        return data;
    }

    public void setData(PlayList[] data) {
        this.data = data;
    }
}
