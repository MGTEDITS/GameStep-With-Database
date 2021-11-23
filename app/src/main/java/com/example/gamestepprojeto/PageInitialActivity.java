package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PageInitialActivity extends AppCompatActivity {

    ImageButton btnmenu, btnvideo;
    ImageView ivmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageinitialactivity);

        btnmenu=findViewById(R.id.btnmenu);
        btnvideo=findViewById(R.id.btnvideos);

        //Ao clicar no botão do comando o menu irá estar visivel ou invisivel
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivmenu=findViewById(R.id.ivmenu);
                if (ivmenu.getVisibility() == View.VISIBLE) {
                    ivmenu.setVisibility(View.INVISIBLE);
                    btnvideo.setVisibility(View.INVISIBLE);
                }
                else {
                    ivmenu.setVisibility(View.VISIBLE);
                    btnvideo.setVisibility(View.VISIBLE);
                }

            }
        });

        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageInitialActivity.this, ListagemVideos.class);
                startActivity(intent);

            }
        });
    }
}