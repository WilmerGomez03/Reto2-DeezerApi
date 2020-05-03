package com.example.retodeezer.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.retodeezer.R;
import com.example.retodeezer.util.Constants;

public class MainActivity extends AppCompatActivity {

    private ImageButton startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start_Button);

        startButton.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, PlayLists_Activity_1.class);
                    startActivity(i);
                }

        );
    }
}
