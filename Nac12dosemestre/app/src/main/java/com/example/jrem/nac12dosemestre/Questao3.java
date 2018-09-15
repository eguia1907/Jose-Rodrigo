package com.example.jrem.nac12dosemestre;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Questao3 extends AppCompatActivity {

    public final String PreferenceKey = "PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);
    }

    public void addPreference(String chave, String valor){
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(chave, valor);
        ed.apply();
    }

    public String getPreference(String chave) {
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        return  sh.getString(chave, "");
    }

    public void gravaPreferencia(View view){
        EditText edtGravar = findViewById(R.id.edt_gravar);
        addPreference("teste", edtGravar.getText().toString());

    }

    public void recuperaPreferencia(View view){
        TextView txtMensagem = findViewById(R.id.txt_mensagem);
        txtMensagem.setText(getPreference("teste"));
    }

}
