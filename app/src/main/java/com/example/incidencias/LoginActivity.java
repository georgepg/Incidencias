package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtEmailLogin,edtPasswordLogin;
    MaterialButton btninicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        btninicioSesion = findViewById(R.id.btninicioSesion);
        btninicioSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }
    private void validate() {
        String email = edtEmailLogin.getText().toString().trim();
        String password = edtPasswordLogin.getText().toString().trim();
        if (email.isEmpty()){
            edtEmailLogin.setError("La casilla esta vacia");

        }else if (!email.equalsIgnoreCase("admin")){
            edtEmailLogin.setError("Dato incorrecto prueba otra vez");
        }
        else if (password.isEmpty()){
            edtPasswordLogin.setError("La casilla esta vacia");
        }
        else if (!password.equalsIgnoreCase("admin")){
            edtPasswordLogin.setError("Dato incorrecto prueba otra vez");
        }else{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}