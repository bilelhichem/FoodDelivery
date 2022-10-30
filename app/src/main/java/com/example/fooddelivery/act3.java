package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class act3 extends AppCompatActivity {
    ImageView home , order , profil , favorite ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        init();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FrameFragment,new homefrag())
                .commit();


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FrameFragment,new homefrag())
                        .commit();
                home.setColorFilter(getColor(R.color.white));
                profil.setColorFilter(getColor(R.color.black));
                favorite.setColorFilter(getColor(R.color.black));
                order.setColorFilter(getColor(R.color.black));
            }
        });


        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FrameFragment,new favoritefrag())
                        .commit();
                home.setColorFilter(getColor(R.color.black));
                profil.setColorFilter(getColor(R.color.black));
                favorite.setColorFilter(getColor(R.color.white));
                order.setColorFilter(getColor(R.color.black));
            }
        });



        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FrameFragment,new orderfrag())
                        .commit();
                home.setColorFilter(getColor(R.color.black));
                profil.setColorFilter(getColor(R.color.black));
                favorite.setColorFilter(getColor(R.color.black));
                order.setColorFilter(getColor(R.color.white));
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FrameFragment,new profilfrag())
                        .commit();
                home.setColorFilter(getColor(R.color.black));
                profil.setColorFilter(getColor(R.color.white));
                favorite.setColorFilter(getColor(R.color.black));
                order.setColorFilter(getColor(R.color.black));
            }
        });





    }

    public void init(){
        home = findViewById(R.id.home);
        favorite = findViewById(R.id.favorite) ;
        order = findViewById(R.id.order);
        profil = findViewById(R.id.profil);
    }


}