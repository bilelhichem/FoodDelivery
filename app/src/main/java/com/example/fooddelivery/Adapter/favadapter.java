package com.example.fooddelivery.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.Model.favmodel;
import com.example.fooddelivery.R;
import com.example.fooddelivery.ViewHorder.favviewhorder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class favadapter extends RecyclerView.Adapter<favviewhorder> {
    Context context ;
    ArrayList<favmodel> favmodels ;
    DatabaseReference imgdb ;

    public favadapter(Context context, ArrayList<favmodel> favmodels) {
        this.context = context;
        this.favmodels = favmodels;
        if (context != null){
            imgdb =  FirebaseDatabase.getInstance(context.getString(R.string.db_url)).getReference().child("favorite");
        }
    }

    @NonNull
    @Override
    public favviewhorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.prodfav,parent,false);
        return new favviewhorder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull favviewhorder holder, int position) {
        Picasso.get().load(favmodels.get(position).getProdimg()).into(holder.imgdeprod);
        holder.namedeprod.setText(favmodels.get(position).getNameprod());
        holder.prixdeprod.setText(String.valueOf(favmodels.get(position).getPrix())+" "+"DZD");
        holder.superprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder mydialog = new AlertDialog.Builder(context);
                mydialog.setTitle("Delete "+favmodels.get(position).getNameprod());
                mydialog.setMessage("Do you really want to delete "
                        +favmodels.get(position).getNameprod()+"?");

                mydialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        imgdb.child(favmodels.get(position).getProdid())
                                .removeValue()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(context, "Product Remove", Toast.LENGTH_SHORT).show();

                                        }
                                        else {
                                            Toast.makeText(context, "Error , check your internet connexion", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });


                mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });


                mydialog.show();




            }
        });





    }

    @Override
    public int getItemCount() {
        return favmodels.size();
    }
}
