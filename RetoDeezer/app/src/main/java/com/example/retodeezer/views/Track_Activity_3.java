package com.example.retodeezer.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retodeezer.R;
import com.example.retodeezer.controllers.TrackController;
import com.example.retodeezer.model.Track;

public class Track_Activity_3 extends AppCompatActivity {

    private Track track;
    private TrackController controller;

    private ImageView coverTrack;
    private TextView nameTrack;
    private TextView nameArtist;
    private TextView nameAlbum;
    private TextView trackTime;
    private ImageButton playButton;
    private ImageButton goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.track_activity_3);

        track = (Track) getIntent().getExtras().getSerializable("track");

        this.coverTrack =  findViewById(R.id.cover_Track_3);
        this.nameTrack =  findViewById(R.id.name_track_3);
        this.nameArtist =  findViewById(R.id.name_artist_3);
        this.nameAlbum =  findViewById(R.id.name_album);
        this.trackTime =  findViewById(R.id.track_time);
        this.playButton = findViewById(R.id.play_Button);
        this.goBack = findViewById(R.id.go_Back_3);
        goBack.setOnClickListener(
                (v)->{
                    onBackPressed();
                }

        );


        this.controller = new TrackController(this);
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public TrackController getController() {
        return controller;
    }

    public void setController(TrackController controller) {
        this.controller = controller;
    }

    public ImageView getCoverTrack() {
        return coverTrack;
    }

    public void setCoverTrack(ImageView coverTrack) {
        this.coverTrack = coverTrack;
    }

    public TextView getNameTrack() {
        return nameTrack;
    }

    public void setNameTrack(TextView nameTrack) {
        this.nameTrack = nameTrack;
    }

    public TextView getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(TextView nameArtist) {
        this.nameArtist = nameArtist;
    }

    public TextView getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(TextView nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public TextView getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(TextView trackTime) {
        this.trackTime = trackTime;
    }

    public ImageButton getPlayButton() {
        return playButton;
    }

    public void setPlayButton(ImageButton playButton) {
        this.playButton = playButton;
    }
}
