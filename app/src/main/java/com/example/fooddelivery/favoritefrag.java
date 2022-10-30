package com.example.fooddelivery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.Adapter.favadapter;
import com.example.fooddelivery.Adapter.prodadapter;
import com.example.fooddelivery.Model.favmodel;
import com.example.fooddelivery.Model.getprod;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class favoritefrag extends Fragment {
RecyclerView favliste ;
View mview ;
    DatabaseReference imgdb ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview =inflater.inflate(R.layout.fragment_favoritefrag, container, false);
        favliste = mview.findViewById(R.id.favlist);
        imgdb = FirebaseDatabase.getInstance(getActivity().getString(R.string.db_url)).getReference().child("favorite");

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        favliste.setLayoutManager(linearLayoutManager);
         initadapter();




        return mview ;
    }




public void initadapter(){
        ArrayList<favmodel> favmodels = new ArrayList<>() ;
        imgdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                favmodels.clear();
                for (DataSnapshot onesnap : snapshot.getChildren()){
                    favmodel favmodel = onesnap.getValue(favmodel.class);
                    favmodels.add(favmodel);
                }
                 favadapter favadapter = new favadapter(getActivity(),favmodels);
                favliste.setAdapter(favadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



}





}