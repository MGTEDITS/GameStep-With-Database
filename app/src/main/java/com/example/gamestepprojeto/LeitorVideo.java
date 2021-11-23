package com.example.gamestepprojeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class LeitorVideo extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView ;
    TextView lbtitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leitor_video);
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        lbtitulo=findViewById(R.id.lbtitulo);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                Intent intent = new Intent(LeitorVideo.this,ListagemVideos.class);
                String videoId = getIntent().getStringExtra("link");
                String titulo = getIntent().getStringExtra("titulo");
                lbtitulo.setText(titulo);
                Log.d("TAG", videoId);
                youTubePlayer.loadVideo(videoId,0);
            }
        });

    }
}