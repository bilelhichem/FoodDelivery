package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mauth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mauth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mauth.getCurrentUser() != null){
                    Intent i = new Intent(MainActivity.this,act3.class);
                    startActivity(i);
                    finish();
                }   else {
                    Intent i = new Intent(MainActivity.this,act2.class);
                    startActivity(i);
                    finish();}
            }
        },700);

    }
}