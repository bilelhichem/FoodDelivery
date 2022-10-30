package com.example.fooddelivery.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.Model.getprod;
import com.example.fooddelivery.R;
import com.example.fooddelivery.ViewHorder.prodviewhorder;
import com.example.fooddelivery.pageproduit;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class prodadapter extends RecyclerView.Adapter<prodviewhorder> {
    Context context ;
    ArrayList<getprod> getprods ;

    public prodadapter(Context context, ArrayList<getprod> getprods) {
        this.context = context;
        this.getprods = getprods;
    }

    @NonNull
    @Override
    public prodviewhorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product,parent,false);
        return  new prodviewhorder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull prodviewhorder holder, int position) {
       Picasso.get().load(getprods.get(position).prodimg).into(holder.prodimg);
        holder.nameprod.setText(getprods.get(position).getNameprod());
        holder.prix.setText(String.valueOf(getprods.get(position).getPrix())+" "+"DZD");

        holder.abz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, pageproduit.class);
                intent.putExtra("nameprod",getprods.get(position).getNameprod());
                intent.putExtra("prixprod",String.valueOf(getprods.get(position).getPrix()));
                intent.putExtra("imgprod",getprods.get(position).getProdimg());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getprods.size();
    }
}
