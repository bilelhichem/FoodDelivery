package com.example.fooddelivery.ViewHorder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

public class favviewhorder extends RecyclerView.ViewHolder {
    public   ImageView imgdeprod , superprod ;
    public TextView namedeprod  , prixdeprod ;

    public favviewhorder(@NonNull View itemView) {
        super(itemView);
        imgdeprod = itemView.findViewById(R.id.imgprod);
        superprod = itemView.findViewById(R.id.superprod);
        namedeprod = itemView.findViewById(R.id.nameprod);
        prixdeprod = itemView.findViewById(R.id.prixdeprod);
    }
}
