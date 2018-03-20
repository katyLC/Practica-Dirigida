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
    EditText texto;
    EditText editText;
    EditText ingresar;
    TextView mostrarR;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (EditText) findViewById(R.id.edit_text);

        ingresar = (EditText) findViewById(R.id.ingresar);

    }


    public void hacer(View view) {
        Intent intent = new Intent(this, MainResultado.class);

        String tex = texto.getText().toString();
        String num = ingresar.getText().toString();
        intent.putExtra("texto", tex);
        intent.putExtra("ingresar", num);
        startActivity(intent);

    }
}




