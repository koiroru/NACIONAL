package com.example.nacional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private List<Peliculas> ListPelicula = new ArrayList<Peliculas>();
    ArrayAdapter<Peliculas> arrayAdapterPelicula;
    ListView lvListadoPeliculas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvListadoPeliculas=findViewById(R.id.LVlistaPeliculas);
        inicializarFireBase();
        listarDatos();
    }
    private void listarDatos() {
        databaseReference.child("Peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListPelicula.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    Peliculas pe =objs.getValue(Peliculas.class);
                    ListPelicula.add(pe);
                    arrayAdapterPelicula =new ArrayAdapter<Peliculas>(ListaActivity.this, android.R.layout.simple_expandable_list_item_1,ListPelicula);
                    lvListadoPeliculas.setAdapter(arrayAdapterPelicula);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
}
