package com.example.music;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button playBtn, pauseBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        stopBtn = findViewById(R.id.stopBtn);

        mp = MediaPlayer.create(this, R.raw.song);

        playBtn.setOnClickListener(v -> mp.start());

        pauseBtn.setOnClickListener(v -> mp.pause());

        stopBtn.setOnClickListener(v -> {
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.song);
        });
    }
}