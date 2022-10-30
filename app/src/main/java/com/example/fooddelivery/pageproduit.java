package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddelivery.Model.favmodel;
import com.example.fooddelivery.Model.getprod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class pageproduit extends AppCompatActivity {
TextView nameprod , prixprod,chehalmnprod;
ImageView imgprod ,add,sous,alb;
Button  addprodincart ;
    int ii  = 0 ;
    String i,l,k;
DatabaseReference datadb , cartdb;
FirebaseAuth mauth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageproduit);
        i = getIntent().getStringExtra("nameprod");
        l = getIntent().getStringExtra("prixprod");

         k = getIntent().getStringExtra("imgprod");
        init();


        nameprod.setText(i);
        prixprod.setText(l);
        Picasso.get().load(k).into(imgprod);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ii = ii +1 ;
                chehalmnprod.setText(String.valueOf(ii));
            }
        });


        sous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ii = ii - 1 ;
                chehalmnprod.setText(String.valueOf(ii));
            }
        });




alb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Integer prix = Integer.valueOf(l) ;
        datadb = FirebaseDatabase.getInstance(getString(R.string.db_url)).getReference().child("favorite");
        datadb = datadb.push();
        String prodid = datadb.getKey();
        favmodel favmodel = new favmodel(i,k,prodid,prix);
        savedonnesindb(favmodel);
    }
});






addprodincart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
   cartdb = FirebaseDatabase.getInstance(getString(R.string.db_url)).getReference().child("cart").child(mauth.getCurrentUser().getUid());







    }
});















    }


    public void init(){
        nameprod = findViewById(R.id.nameprod);
        prixprod = findViewById(R.id.prixprod);
        imgprod = findViewById(R.id.imgprod);
        add = findViewById(R.id.plus);
        sous = findViewById(R.id.sous);
        chehalmnprod = findViewById(R.id.chehalmnprod);
        alb = findViewById(R.id.alb);
        addprodincart = findViewById(R.id.addprodincart);


    }



    public void savedonnesindb(favmodel produit ){
        datadb.setValue(produit)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(pageproduit.this, "produit added", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(pageproduit.this, "errore", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }






}