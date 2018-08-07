package com.example.kuch.col;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button send = findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1= (EditText) findViewById(R.id.t1);
                EditText t2= (EditText) findViewById(R.id.t2);
                EditText t3= (EditText) findViewById(R.id.t3);
                EditText t4= (EditText) findViewById(R.id.t4);

                String name= t1.getText().toString()+t2.getText().toString()+t3.getText().toString()+t4.getText().toString();
                TextView out= (TextView) findViewById(R.id.out);
                out.setText(name);
                FirebaseDatabase firebaseDatabase;
                firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference;
                databaseReference = FirebaseDatabase.getInstance().getReference("data");
                databaseReference.push().setValue("area : "+ t1.getText().toString()+",crop : "+t2.getText().toString()+",water : "+t3.getText().toString()+",soil : "+t4.getText().toString());

               /* databaseReference = FirebaseDatabase.getInstance().getReference("area");
                databaseReference.push().setValue(t1.getText().toString());
                databaseReference = FirebaseDatabase.getInstance().getReference("crop");
                databaseReference.push().setValue(t2.getText().toString());
                databaseReference = FirebaseDatabase.getInstance().getReference("water");
                databaseReference.push().setValue(t3.getText().toString());
                databaseReference = FirebaseDatabase.getInstance().getReference("soil");
                databaseReference.push().setValue(t4.getText().toString());*/


            }
        });
    }
}
