package com.example.katherine.practicadirgida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText parrafo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parrafo = findViewById(R.id.edtParrafo);
        Button mostrar = findViewById(R.id.btnMostrar);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parrafo.getText() != null && parrafo.getText().length() > 0) {
                    mostrarInfo(String.valueOf(parrafo.getText()));
                } else {
                    Toast.makeText(getApplicationContext(), "Debe ingresar por lo menos un valor",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void mostrarInfo(String parrafo) {
        Intent intent = new Intent(this, MostrarActivity.class);
        intent.putExtra("parrafo", parrafo);
        startActivity(intent);
    }
}




