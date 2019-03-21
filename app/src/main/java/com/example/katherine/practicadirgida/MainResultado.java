package com.example.katherine.practicadirgida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.StringTokenizer;

public class MainResultado extends AppCompatActivity {

    TextView tvCantidadPalabras;
    TextView tvPalabrasRepetidas;
    TextView tvPalindromos;
    TextView tvParrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultado);

        tvCantidadPalabras = findViewById(R.id.tvCantidadPalabras);
        tvPalabrasRepetidas = findViewById(R.id.tvPalabrasRepetidas);
        tvPalindromos = findViewById(R.id.tvPalindromos);
        tvParrafo = findViewById(R.id.tvParrafo);

        Intent intent = getIntent();
        String parrafo = intent.getStringExtra("parrafo");

        tvCantidadPalabras.setText(String.valueOf(calcularCantidadPalabras(parrafo)));

        cantidadVecesRepite(parrafo.split(" "));
        palindromo(parrafo.split(" "));

        tvParrafo.setText(parrafo);
    }

    public int calcularCantidadPalabras(String parrafo) {
        String[] cantPalabras = parrafo.split(" ");
        return cantPalabras.length;
    }

    public void cantidadVecesRepite(String[] parrafo) {
        HashMap<String, Integer> palabras = new HashMap<>();
        for (String palabra : parrafo) {
            palabras.put(palabra, palabras.containsKey(palabra) ? palabras.get(palabra) + 1 : 1);
        }
        for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
            tvPalabrasRepetidas.setText(tvPalabrasRepetidas.getText() + "\n" + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void palindromo(String[] parrafo) {
        HashMap<String, String> palabras = new HashMap<>();
        for (String palabra : parrafo) {
            int inicio = 0;
            int fin = palabra.length() - 1;
            boolean fallo = false;

            while ((inicio < fin)) {
                if (palabra.toLowerCase().charAt(inicio) == palabra.toLowerCase().charAt(fin)) {
                    inicio++;
                    fin--;
                } else {
                    fallo = true;
                    break;
                }
            }

            palabras.put(palabra, fallo ? "NO" : "SI");
        }

        for (Map.Entry<String, String> entry : palabras.entrySet()) {
            tvPalindromos.setText(tvPalindromos.getText() + "\n" + entry.getKey() + ": " + entry.getValue());
        }

    }
}