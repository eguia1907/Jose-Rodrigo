package com.example.jrem.nac12dosemestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_questaoDois = findViewById(R.id.btn_questaoDois);
        btn_questaoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Questao2.class) ;
                startActivity(i);

            }
        });

    }

    public void executaConsulta(View view){

        String response;
        String url = "https://jsonplaceholder.typicode.com/todos/";



        EditText edId = findViewById(R.id.edt_id);
        url += edId.getText().toString();

        EditText edtTitle = findViewById(R.id.edt_title);
        EditText edtComp = findViewById(R.id.edt_comp);
        TextView txtMensagem = findViewById(R.id.txt_mensagem);

        new DataGetter(edtTitle,edtComp, txtMensagem).execute(url);

    }




}
