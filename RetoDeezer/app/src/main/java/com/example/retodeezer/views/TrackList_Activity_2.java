package com.example.retodeezer.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retodeezer.R;
import com.example.retodeezer.adapters.TrackAdapter;
import com.example.retodeezer.controllers.PlayListController;
import com.example.retodeezer.model.PlayList;

public class TrackList_Activity_2 extends AppCompatActivity {

    private PlayListController controller;
    private TrackAdapter adapter;

    private PlayList playList;
    private ListView listTable2;
    private ImageView coverPlaylist;
    private TextView namePlaylist;
    private TextView descriptionPlaylist;
    private TextView numTracks;
    private ImageButton goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.tracklist_activity_2);

        this.playList = (PlayList) getIntent().getExtras().getSerializable("playlist");

        this.listTable2 = findViewById(R.id.listTable2);
        this.coverPlaylist =  findViewById(R.id.cover_Playlist);
        this.namePlaylist =  findViewById(R.id.name_playlist);
        this.descriptionPlaylist =  findViewById(R.id.description_playlist);
        this.numTracks =  findViewById(R.id.num_Tracks);
        this.goBack = findViewById(R.id.go_Back_2);
        goBack.setOnClickListener(
                (v)->{
                    onBackPressed();
                }

        );
        this.controller = new PlayListController(this);
        this.adapter = new TrackAdapter(this);
        this.listTable2.setAdapter(adapter);

    }

    public PlayListController getController() {
        return controller;
    }

    public void setController(PlayListController controller) {
        this.controller = controller;
    }

    public TrackAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(TrackAdapter adapter) {
        this.adapter = adapter;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public ListView getListTable2() {
        return listTable2;
    }

    public void setListTable2(ListView listTable2) {
        this.listTable2 = listTable2;
    }

    public ImageView getCoverPlaylist() {
        return coverPlaylist;
    }

    public void setCoverPlaylist(ImageView coverPlaylist) {
        this.coverPlaylist = coverPlaylist;
    }

    public TextView getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(TextView namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public TextView getDescriptionPlaylist() {
        return descriptionPlaylist;
    }

    public void setDescriptionPlaylist(TextView descriptionPlaylist) {
        this.descriptionPlaylist = descriptionPlaylist;
    }

    public TextView getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(TextView numTracks) {
        this.numTracks = numTracks;
    }
}
