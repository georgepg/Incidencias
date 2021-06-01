package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    private static final String TAG = "ViewActivity";
    DatabaseHelper mDatabaseHelper;
    RecyclerView rcvIncidencias;
    List<Incidencia> element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        rcvIncidencias = findViewById(R.id.rcvIncidencias);
        mDatabaseHelper = new DatabaseHelper(this);
        IncidenciasRecyclerView();
    }

    private void IncidenciasRecyclerView() {
        Log.d(TAG,"Lista de Incidencias: Mostrando datos en la lista");
        Cursor data = mDatabaseHelper.getData();
        element = new ArrayList<>();
        while(data.moveToNext()){
            element.add(new Incidencia(data.getString(1)));
        }

        AdapterIncidencias listAdapter = new AdapterIncidencias(element, this);
        rcvIncidencias.setHasFixedSize(true);
        rcvIncidencias.setLayoutManager(new LinearLayoutManager(this));
        rcvIncidencias.setAdapter(listAdapter);
        //ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        //rcvIncidencias.setAdapter(adapter);

    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}