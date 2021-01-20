package com.example.aguasriojanas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button iniciar_sesion;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_bienvenido);

      iniciar_sesion = findViewById(R.id.btn_login);


    }
}

