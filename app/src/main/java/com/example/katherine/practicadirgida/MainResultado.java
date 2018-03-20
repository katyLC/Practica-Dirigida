package com.example.katherine.practicadirgida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.StringTokenizer;

public class MainResultado extends AppCompatActivity {

    TextView palabraTotal;
    TextView palabraRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultado);

        Intent intent = getIntent();
        String texto = intent.getStringExtra("texto");
        String nume = intent.getStringExtra("ingresar");
        palabraTotal = (TextView) findViewById(R.id.mostrarCantidad);
        palabraRandom = (TextView) findViewById(R.id.resultadoRandon);

        StringTokenizer tokenizer = new StringTokenizer(texto, " ");
        palabraTotal.setText(String.valueOf(tokenizer.countTokens()));
        String letras[] = texto.split(" ");
        Integer randon;
        String mostrar = " ";
        for (int i = 0; i < Integer.parseInt(nume); i++) {
            randon = new Random().nextInt(letras.length);
            mostrar += letras[randon] + " ";
        }
        palabraRandom.setText(mostrar);
    }
}