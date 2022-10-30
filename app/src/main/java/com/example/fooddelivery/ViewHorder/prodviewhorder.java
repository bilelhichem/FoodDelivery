package com.example.fooddelivery.ViewHorder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

public class prodviewhorder extends RecyclerView.ViewHolder {
   public TextView nameprod , prix  ;
   public RelativeLayout abz ;
   public ImageView prodimg ;
    public prodviewhorder(@NonNull View itemView) {
        super(itemView);
        nameprod = itemView.findViewById(R.id.nameprod);
        prix = itemView.findViewById(R.id.prixprod);
        prodimg = itemView.findViewById(R.id.imgprod);
        abz = itemView.findViewById(R.id.abz);
    }
}
