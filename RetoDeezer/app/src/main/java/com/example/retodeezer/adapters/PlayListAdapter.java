package com.example.retodeezer.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.model.PlayList;
import com.example.retodeezer.views.PlayLists_Activity_1;
import com.example.retodeezer.views.TrackList_Activity_2;


public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.ViewPlayList> {

    private PlayList[] playLists;
    private PlayLists_Activity_1 activity;

    public PlayListAdapter(PlayLists_Activity_1 activity, PlayList[] playLists){
        this.activity = activity;
        this.playLists = playLists;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    public void setPlayLists(PlayList[] playLists) {
        this.playLists = playLists;
    }

    public PlayLists_Activity_1 getActivity_1() {
        return activity;
    }

    public void setActivity_1(PlayLists_Activity_1 activity_1) {
        this.activity = activity_1;
    }


    @Override
    public ViewPlayList onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.playlists_info, parent, false);

        return new ViewPlayList(view);
    }

    @Override
    public void onBindViewHolder(ViewPlayList holder, int position) {
        holder.setInfo(playLists[position]);
    }

    @Override
    public int getItemCount() {
        return playLists.length;
    }

    public class ViewPlayList extends RecyclerView.ViewHolder {

        private TextView namePlaylist;
        private TextView nameUser;
        private TextView numItems;
        private ImageView coverTrack;

        public ViewPlayList(@NonNull View itemView) {
            super(itemView);
            coverTrack = itemView.findViewById(R.id.cover_Playlists_1);
            namePlaylist = itemView.findViewById(R.id.name_Playlist_1);
            nameUser = itemView.findViewById(R.id.name_user_1);
            numItems = itemView.findViewById(R.id.num_items_1);


        }

        public void setInfo(PlayList playList){

            try {

                namePlaylist.setText(playList.getTitle());
                nameUser.setText("User: "+playList.getUser().getName());
                numItems.setText("Tracks: "+playList.getNb_tracks());

                Glide.with(itemView).load(playList.getPicture()).centerCrop().into(coverTrack);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(activity, TrackList_Activity_2.class);
                        i.putExtra("playlist",playList);
                        activity.startActivity(i);
                    }
                });
            }catch (Exception e){
                Log.e(">>>",e.getMessage());
            }

        }
    }
}
