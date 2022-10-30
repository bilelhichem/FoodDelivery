package com.example.fooddelivery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fooddelivery.Adapter.prodadapter;
import com.example.fooddelivery.Model.getprod;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class homefrag extends Fragment {
    View mview ;
    CardView car1 , car2 ,car3,car4;
    LinearLayout lin1 , lin2 ,lin3,lin4;
    ImageView pic1 , pic2 ,pic3,pic4;
    TextView tec1 , tec2,tec3,tec4 ;
    RecyclerView prodlist;
    DatabaseReference imgdb ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_homefrag, container, false) ;
        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        prodlist.setLayoutManager(linearLayoutManager);

        ArrayList<getprod> getprods = new ArrayList<>();
        imgdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                getprods.clear();
                for (DataSnapshot onesnap : snapshot.getChildren() ){
                    if (onesnap.child("category").getValue().equals("Hamburger")){
                        getprod getprod = onesnap.getValue(getprod.class);
                        getprods.add(getprod);
                    }
                }
                prodadapter prodadapter = new prodadapter(getActivity(),getprods);
                prodlist.setAdapter(prodadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin1.setBackground(getContext().getDrawable(R.drawable.myback4));
                pic1.setColorFilter(getContext().getColor(R.color.vert));
                tec1.setTextColor(getContext().getColor(R.color.vert));
                lin2.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic2.setColorFilter(getContext().getColor(R.color.black));
                tec2.setTextColor(getContext().getColor(R.color.gris));
                tec3.setTextColor(getContext().getColor(R.color.gris));
                lin3.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic3.setColorFilter(getContext().getColor(R.color.black));
                tec4.setTextColor(getContext().getColor(R.color.gris));
                lin4.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic4.setColorFilter(getContext().getColor(R.color.black));


                ArrayList<getprod> getprods = new ArrayList<>();
                imgdb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        getprods.clear();
                        for (DataSnapshot onesnap : snapshot.getChildren() ){
                             if (onesnap.child("category").getValue().equals("Hamburger")){
                                 getprod getprod = onesnap.getValue(getprod.class);
                                 getprods.add(getprod);
                             }
                        }
                        prodadapter prodadapter = new prodadapter(getActivity(),getprods);
                        prodlist.setAdapter(prodadapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });


        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin2.setBackground(getContext().getDrawable(R.drawable.myback4));
                pic2.setColorFilter(getContext().getColor(R.color.vert));
                tec2.setTextColor(getContext().getColor(R.color.vert));
                lin1.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic1.setColorFilter(getContext().getColor(R.color.black));
                tec1.setTextColor(getContext().getColor(R.color.gris));
                tec3.setTextColor(getContext().getColor(R.color.gris));
                lin3.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic3.setColorFilter(getContext().getColor(R.color.black));
                tec4.setTextColor(getContext().getColor(R.color.gris));
                lin4.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic4.setColorFilter(getContext().getColor(R.color.black));

                ArrayList<getprod> getprods = new ArrayList<>();
                imgdb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        getprods.clear();
                        for (DataSnapshot onesnap : snapshot.getChildren() ){
                            if (onesnap.child("category").getValue().equals("Sandwich")){
                                getprod getprod = onesnap.getValue(getprod.class);
                                getprods.add(getprod);
                            }
                        }
                        prodadapter prodadapter = new prodadapter(getActivity(),getprods);
                        prodlist.setAdapter(prodadapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin2.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic2.setColorFilter(getContext().getColor(R.color.black));
                tec2.setTextColor(getContext().getColor(R.color.gris));
                lin1.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic1.setColorFilter(getContext().getColor(R.color.black));
                tec1.setTextColor(getContext().getColor(R.color.gris));
                tec3.setTextColor(getContext().getColor(R.color.vert));
                lin3.setBackground(getContext().getDrawable(R.drawable.myback4));
                pic3.setColorFilter(getContext().getColor(R.color.vert));
                tec4.setTextColor(getContext().getColor(R.color.gris));
                lin4.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic4.setColorFilter(getContext().getColor(R.color.black));
                ArrayList<getprod> getprods = new ArrayList<>();
                imgdb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        getprods.clear();
                        for (DataSnapshot onesnap : snapshot.getChildren() ){
                            if (onesnap.child("category").getValue().equals("Pizza")){
                                getprod getprod = onesnap.getValue(getprod.class);
                                getprods.add(getprod);
                            }
                        }
                        prodadapter prodadapter = new prodadapter(getActivity(),getprods);
                        prodlist.setAdapter(prodadapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



        car4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin2.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic2.setColorFilter(getContext().getColor(R.color.black));
                tec2.setTextColor(getContext().getColor(R.color.black));
                lin1.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic1.setColorFilter(getContext().getColor(R.color.black));
                tec1.setTextColor(getContext().getColor(R.color.gris));
                tec3.setTextColor(getContext().getColor(R.color.gris));
                lin3.setBackground(getContext().getDrawable(R.drawable.myback5));
                pic3.setColorFilter(getContext().getColor(R.color.black));
                tec4.setTextColor(getContext().getColor(R.color.vert));
                lin4.setBackground(getContext().getDrawable(R.drawable.myback4));
                pic4.setColorFilter(getContext().getColor(R.color.vert));
                ArrayList<getprod> getprods = new ArrayList<>();
                imgdb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        getprods.clear();
                        for (DataSnapshot onesnap : snapshot.getChildren() ){
                            if (onesnap.child("category").getValue().equals("fried")){
                                getprod getprod = onesnap.getValue(getprod.class);
                                getprods.add(getprod);
                            }
                        }
                        prodadapter prodadapter = new prodadapter(getActivity(),getprods);
                        prodlist.setAdapter(prodadapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });








        return mview;
    }

    public void  init(){
        car1 = mview.findViewById(R.id.car1);
        car2 = mview.findViewById(R.id.car2);
        lin1 = mview.findViewById(R.id.lin1);
        lin2 = mview.findViewById(R.id.lin2);
        pic1 = mview.findViewById(R.id.pic1);
        pic2 = mview.findViewById(R.id.pic2);
        tec1 = mview.findViewById(R.id.tec1);
        tec2 = mview.findViewById(R.id.tec2);
        car3 = mview.findViewById(R.id.car3);
        car4 = mview.findViewById(R.id.car4);
        lin3 = mview.findViewById(R.id.lin3);
        lin4 = mview.findViewById(R.id.lin4);
        pic3 = mview.findViewById(R.id.pic3);
        pic4 = mview.findViewById(R.id.pic4);
        tec3 = mview.findViewById(R.id.tec3);
        tec4 = mview.findViewById(R.id.tec4);
        imgdb = FirebaseDatabase.getInstance(getContext().getString(R.string.db_url)).getReference().child("Product");
        prodlist = mview.findViewById(R.id.prodlist);


    }

    public  void initadap(){

    }


}