package com.example.retodeezer.controllers;

import android.util.Log;
import android.view.View;

import com.example.retodeezer.R;
import com.example.retodeezer.adapters.PlayListAdapter;
import com.example.retodeezer.model.PlayListsLoader;
import com.example.retodeezer.util.Constants;
import com.example.retodeezer.util.HTTPSWebUtilDomi;
import com.example.retodeezer.views.PlayLists_Activity_1;
import com.google.gson.Gson;


public class SearchPlayListController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private PlayLists_Activity_1 activity;
    private HTTPSWebUtilDomi utildomi;
    private PlayListsLoader playListLoader;

    public SearchPlayListController(PlayLists_Activity_1 activity) {
        this.activity = activity;
        this.utildomi = new HTTPSWebUtilDomi();
        this.utildomi.setListener(this);
        activity.getSearch_Button().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.searchButton:

                    String nameList = activity.getSearch_input().getText().toString();

                    new Thread(
                            ()->{
                                utildomi.GETrequest(Constants.SEARCH_CALLBACK,"https://api.deezer.com/search/playlist?q="+nameList);
                            }
                    ).start();

                    break;

            }
        }catch (Exception e){
            Log.e(">>>","error in SearchPlayListController onClick");
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        try {
            switch (callbackID){
                case Constants.SEARCH_CALLBACK:
                    Gson gson = new Gson();
                    playListLoader = gson.fromJson(response, PlayListsLoader.class);

                    if(playListLoader.getData()!=null){
                        activity.runOnUiThread(
                                ()->{
                                    PlayListAdapter adapter = new PlayListAdapter(activity, playListLoader.getData());
                                    activity.setAdapter(adapter);
                                    activity.getRecyclerView().setAdapter(adapter);
                                }
                        );
                    }

                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in SearchPlayListController onResponse");
        }
    }
}
