package com.example.retodeezer.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.retodeezer.R;
import com.example.retodeezer.adapters.PlayListAdapter;
import com.example.retodeezer.controllers.SearchPlayListController;

public class PlayLists_Activity_1 extends AppCompatActivity {

    private PlayListAdapter adapter;
    private SearchPlayListController controller;

    private EditText search_input;
    private ImageButton search_Button;
    private ImageButton go_Back;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.playlists_activity_1);

        this.search_input = findViewById(R.id.seachInput);
        this.search_Button = findViewById(R.id.searchButton);
        this.go_Back=findViewById(R.id.goBack);
        go_Back.setOnClickListener(
                (v)->{
                    onBackPressed();
                }

        );

        this.controller = new SearchPlayListController(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    public PlayListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(PlayListAdapter adapter) {
        this.adapter = adapter;
    }

    public SearchPlayListController getController() {
        return controller;
    }

    public void setController(SearchPlayListController controller) {
        this.controller = controller;
    }

    public EditText getSearch_input() {
        return search_input;
    }

    public void setSearch_input(EditText search_input) {
        this.search_input = search_input;
    }

    public ImageButton getSearch_Button() {
        return search_Button;
    }

    public void setSearch_Button(ImageButton search_Button) {
        this.search_Button = search_Button;
    }

    public ImageButton getGo_Back() {
        return go_Back;
    }

    public void setGo_Back(ImageButton go_Back) {
        this.go_Back = go_Back;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
