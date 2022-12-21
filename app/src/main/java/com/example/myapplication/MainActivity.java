package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.example.myapplication.adapters.MensajeAdapter;
import com.example.myapplication.models.eefefe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewData;
    private DatabaseReference mDatabase;

    private MensajeAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<eefefe> mMensajesList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewData=(TextView) findViewById(R.id.textViewData);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecyclerView =(RecyclerView) findViewById(R.id.recyclerViewMensajes);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDatabase.child("eefefe").child("lecturas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nombre =snapshot.getValue().toString();
                    mTextViewData.setText(nombre);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








    }



}