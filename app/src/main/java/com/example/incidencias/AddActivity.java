package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {
    private static final String TAG = "AddActivity";
    DatabaseHelper mDatabaseHelper;
    MaterialButton btnAgregar,btnVolver;
    TextInputEditText edtnameIncidencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtnameIncidencia = findViewById(R.id.edtnameIncidencia);
        btnVolver= findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAgregar= findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entrada = edtnameIncidencia.getText().toString().trim();

                if(entrada.isEmpty()){
                    edtnameIncidencia.setError("La casilla esta vacia");
                }else {
                    AddData(entrada);
                    edtnameIncidencia.setText("");
                }
            }
        });
        edtnameIncidencia = findViewById(R.id.edtnameIncidencia);
        mDatabaseHelper = new DatabaseHelper(this);
    }
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData){
            toastMessage("Datos insertado correctamente!");
        }else {
            toastMessage("Ha ocurrido un error");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}