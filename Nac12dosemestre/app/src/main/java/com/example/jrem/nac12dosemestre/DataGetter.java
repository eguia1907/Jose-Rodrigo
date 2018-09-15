package com.example.jrem.nac12dosemestre;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String, Void, String> {

    private TextView edtTitle;
    private TextView edtCompleted;
    private TextView txtMensagem;

    public DataGetter(TextView edtTitle, TextView txtSobrenome, TextView txtMensagem) {
        this.edtTitle = edtTitle;
        this.edtCompleted = txtSobrenome;
        this.txtMensagem = txtMensagem;

        txtMensagem.setText("Pesquisando ...");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.getJSONFromAPI(url);

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        txtMensagem.setText("Encontrado");

        try{
            JSONObject jsonResponse = new JSONObject(s);

            String title = jsonResponse.getString("title");
            String completed = jsonResponse.getString("completed");

            edtTitle.setText(title);
            edtCompleted.setText(completed);


        }catch (JSONException e){
            this.txtMensagem.setText("erroJSON");
        }


    }
}
