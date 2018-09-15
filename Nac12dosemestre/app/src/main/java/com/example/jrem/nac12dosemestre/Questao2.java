package com.example.jrem.nac12dosemestre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Questao2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);


    }

    public void executePost(View view) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        EditText edtId = findViewById(R.id.edt_id);
        EditText edtTitle = findViewById(R.id.edt_title);
        EditText edtBody = findViewById(R.id.edt_body);
        TextView txtMensagem = findViewById(R.id.txt_mensagem);


        String parameter =  "{\n" +
                "    \"userId\": "+edtId.getText().toString()+",\n" +
                "    \"title\": "+edtTitle.getText().toString()+",\n" +
                "    \"body\": "+edtBody.getText().toString()+"\n" +
                "}";

        new DataGetterPost(txtMensagem).execute(url,parameter);





    }


}
