package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddelivery.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class act2 extends AppCompatActivity {
    TextView texcard1   , texcard2, forgetpass;
    EditText name, email , pass;
    FirebaseAuth mauth ;
    DatabaseReference datadb ;
    Button btn ;
    ProgressDialog loading;
    Integer verification ;
    CardView card1 , card2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        init();
        loading = new ProgressDialog(act2.this);
        loading.setTitle("Welcome In Delivery Food");
        loading.setMessage("Please wait minute");
        name.setVisibility(View.GONE);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verification = 1 ;
                if (verification == 1) {
                    email.setText("");
                    pass.setText("");
                    name.setText("");
                    card1.setCardBackgroundColor(getColor(R.color.red));
                    card2.setCardBackgroundColor(getColor(R.color.white));
                    texcard1.setTextColor(getColor(R.color.white));
                    texcard2.setTextColor(getColor(R.color.red));
                    name.setVisibility(View.GONE);
                    forgetpass.setVisibility(View.VISIBLE);
                    btn.setText("Sign Up");

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (email.getText().toString().isEmpty()){
                                email.setError("please don't less email empty ");
                            }else  if (pass.getText().toString().isEmpty()){
                                pass.setError("please don't less  password ");
                            } else {
                                loading.show();
                                login();
                            }
                        }
                    });
                }
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verification = 0 ;
                if (verification == 0 ){
                    email.setText("");
                    pass.setText("");
                    name.setText("");
                    card2.setCardBackgroundColor(getColor(R.color.red));
                    card1.setCardBackgroundColor(getColor(R.color.white));
                    texcard2.setTextColor(getColor(R.color.white));
                    texcard1.setTextColor(getColor(R.color.red));
                    forgetpass.setVisibility(View.GONE);
                    name.setVisibility(View.VISIBLE);
                    btn.setText("Sign Up");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (email.getText().toString().isEmpty()){
                                email.setError("please don't less email empty ");
                            }else  if (pass.getText().toString().isEmpty()){
                                pass.setError("please don't less  password ");
                            } else if (name.getText().toString().isEmpty()){
                                name.setError("please don't less name empty");
                            }else {
                                loading.show();
                                creataccount();

                            }



                        }
                    });
                }




            }
        });














    }

    public  void init(){
        name = findViewById(R.id.name);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        texcard1 = findViewById(R.id.textcard1);
        texcard2 = findViewById(R.id.textcard2);
        forgetpass = findViewById(R.id.forgetpass);

        mauth = FirebaseAuth.getInstance();
        datadb = FirebaseDatabase.getInstance(getString(R.string.db_url)).getReference().child("users");
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.btn);
    }


    public  void creataccount(){
        String my_email = email.getText().toString();
        String my_pass = pass.getText().toString();
        mauth.createUserWithEmailAndPassword(my_email,my_pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            saveuserindatabase(new User(my_email,name.getText().toString()));
                        }   else {
                            Toast.makeText(act2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });






    }


    public void saveuserindatabase(User user){
        datadb.child(mauth.getCurrentUser().getUid())
                .setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            loading.dismiss();
                            Intent i = new Intent(act2.this,act3.class);
                            startActivity(i);
                            finish();
                        }else {
                            loading.dismiss();
                            Toast.makeText(act2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    public void login(){
        String my_email = email.getText().toString();
        String my_pass = pass.getText().toString();
        mauth.signInWithEmailAndPassword(my_email,my_pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            loading.dismiss();
                            Intent i = new Intent(act2.this,act3.class);
                            startActivity(i);
                            finish();
                        }else {
                            loading.dismiss();
                            Toast.makeText(act2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }




}