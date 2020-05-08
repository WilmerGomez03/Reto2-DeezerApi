package com.example.retodeezer.controllers;


import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.retodeezer.model.PlayList;
import com.example.retodeezer.model.Track;
import com.example.retodeezer.util.Constants;
import com.example.retodeezer.util.HTTPSWebUtilDomi;
import com.example.retodeezer.views.TrackList_Activity_2;
import com.google.gson.Gson;

public class PlayListController implements HTTPSWebUtilDomi.OnResponseListener {

    private TrackList_Activity_2 activity;
    private HTTPSWebUtilDomi utilDomi;
    private PlayList playList;
    private Track[] tracks;
    private int free;

    public PlayListController(TrackList_Activity_2 activity) {
        this.activity = activity;
        this.utilDomi = new HTTPSWebUtilDomi();
        this.utilDomi.setListener(this);

        loadPlayList(activity.getPlayList().getId());
    }

    @Override
    public void onResponse(int callbackID, String response) {

        try {
            switch (callbackID){
                case Constants.PLAYLIST_CALLBACK:
                    Gson gson = new Gson();
                    this.playList = gson.fromJson(response, PlayList.class);
                    loadView();
                    loadAllTracks(playList.getTracks().getData());
                    break;

                case Constants.TRACKS_CALLBACK:
                    Gson gson2 = new Gson();
                    Track track = gson2.fromJson(response, Track.class);

                    if(track.getId()==null){
                        break;
                    }

                    tracks[free]= track;
                    free++;

                    activity.runOnUiThread(
                            ()->{
                                activity.getAdapter().addTrack(track);
                            }
                    );

                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in PlayListcontroller onResponse");
        }
    }

    public void loadPlayList(long id){
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.PLAYLIST_CALLBACK,"https://api.deezer.com/playlist/"+id);
                }
        ).start();
    }

    public void loadTrack(long id){
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.TRACKS_CALLBACK,"https://api.deezer.com/track/"+id);
                }
        ).start();
    }

    public void loadAllTracks(Track[] data){

        this.tracks = new Track[data.length];
        free = 0;

        for (int i=0;i<data.length;i++){
            if(data[i]!=null){
                loadTrack(data[i].getId());
            }
        }
    }

    public void loadView(){
        try {
            activity.runOnUiThread(
                    ()->{
                        activity.getNamePlaylist().setText(playList.getTitle());
                        activity.getNumTracks().setText("#Tracks: "+playList.getNb_tracks()+" #Fans: "+playList.getFans());
                        Glide.with(activity).load(playList.getPicture_medium()).centerCrop().into(activity.getCoverPlaylist());

                        if(playList.getDescription().equals("")){
                            activity.getDescriptionPlaylist().setText("Sin descripción");
                        }if(playList.getDescription().length()>=40){
                            activity.getDescriptionPlaylist().setText(playList.getDescription().substring(0,40)+"...");
                        }else{
                            activity.getDescriptionPlaylist().setText(playList.getDescription());
                        }
                    }
            );
        }catch (Exception e){
            Log.e(">>>",e.getMessage());
        }
    }

}
