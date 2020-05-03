package com.example.retodeezer.model;

import java.io.Serializable;

public class TracksLoader implements Serializable {

    private Track[] data;
    private String checksum;

    public TracksLoader(Track[] data, String checksum) {
        this.data = data;
        this.checksum = checksum;
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
