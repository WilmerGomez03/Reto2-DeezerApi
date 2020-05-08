package com.example.retodeezer.controllers;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.model.Track;
import com.example.retodeezer.views.Track_Activity_3;

public class TrackController implements View.OnClickListener{

    private Track_Activity_3 activity;
    private Track track;

    public TrackController(Track_Activity_3 activity) {
        this.activity = activity;
        this.track = activity.getTrack();
        activity.getPlayButton().setOnClickListener(this);
        loadView();
    }

    private void loadView() {

        try {
            activity.runOnUiThread(
                    ()->{

                        activity.getNameTrack().setText(track.getTitle_short());
                        activity.getNameArtist().setText(track.getArtist().getName());
                        activity.getNameAlbum().setText(track.getAlbum().getTitle());
                        String time= timeTrack(track.getDuration());
                        activity.getTrackTime().setText("Duración: "+time);

                        Glide.with(activity).load(track.getAlbum().getCover_medium()).centerCrop().into(activity.getCoverTrack());
                    }
            );
        }catch (Exception e){
            Log.e(">>>",e.getMessage());
        }
    }
    private String timeTrack(Long timeSeg){
        long num,hor,min,seg;
        num = timeSeg;
        hor=num/3600;
        min=(num-(3600*hor))/60;
        seg=num-((hor*3600)+(min*60));
        String min2="00";
        String seg2="00";
        if(min<10&&min>0&&hor>0) {
            min2 = "0" + min;
        }else{
            min2=min+"";
        }
        if(seg<10&&seg>0) {
            seg2= "0" + min;
        }else{
            seg2=seg+"";
        }
        if(hor!=0)
            return hor+":"+min2+":"+seg2;
        return min2+":"+seg2;
    }

    @Override
    public void onClick(View view) {

        try {
            switch (view.getId()) {
                case R.id.play_Button:
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(track.getLink()));
                    activity.startActivity(i);
                    break;
            }
        }catch (Exception e){
            Log.e(">>>",e.getMessage());
        }
    }
}
