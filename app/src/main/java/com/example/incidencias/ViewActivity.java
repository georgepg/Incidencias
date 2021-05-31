package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;
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

public class ViewActivity extends AppCompatActivity {
    private static final String TAG = "ViewActivity";
    DatabaseHelper mDatabaseHelper;
    ListView rcvIncidencias;
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
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        rcvIncidencias.setAdapter(adapter);
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