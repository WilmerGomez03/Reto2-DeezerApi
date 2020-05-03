package com.example.retodeezer.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.model.Track;
import com.example.retodeezer.views.TrackList_Activity_2;
import com.example.retodeezer.views.Track_Activity_3;

import java.util.ArrayList;

public class TrackAdapter extends BaseAdapter {

    private TrackList_Activity_2 activity;
    private ArrayList<Track> tracks;

    public TrackAdapter(TrackList_Activity_2 activity) {
        this.activity = activity;
        tracks = new ArrayList<>();
    }

    public void addTrack(Track track){
        tracks.add(track);
        notifyDataSetChanged();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View playlistTrack = inflater.inflate(R.layout.playlist_info,null,false);

        try {
            TextView nameTrack = playlistTrack.findViewById(R.id.name_Track_1);
            TextView trackArtist = playlistTrack.findViewById(R.id.name_Artist_1);
            TextView trackRelease = playlistTrack.findViewById(R.id.date_Release_1);
            ImageView coverTrack = playlistTrack.findViewById(R.id.cover_Track_1);


            nameTrack.setText(tracks.get(position).getTitle());
            trackArtist.setText(tracks.get(position).getArtist().getName());
            trackRelease.setText(tracks.get(position).getRelease_date());

            Glide.with(playlistTrack).load(tracks.get(position).getAlbum().getCover()).centerCrop().into(coverTrack);

            playlistTrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, Track_Activity_3.class);
                    i.putExtra("track",tracks.get(position));
                    activity.startActivity(i);
                }
            });
        }catch (Exception e){
            Log.e(">>>",e.getMessage());
        }

        return playlistTrack;
    }

}
