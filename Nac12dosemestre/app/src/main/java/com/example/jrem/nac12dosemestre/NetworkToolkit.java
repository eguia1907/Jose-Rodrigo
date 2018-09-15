package com.example.jrem.nac12dosemestre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkToolkit {

    public static String getJSONFromAPI(String url) {

        String retorno = "";

        try {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection connection;
            InputStream inputStream;

            connection = (HttpURLConnection) apiEnd.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.connect();

            codigoResposta = connection.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = connection.getInputStream();

            } else {
                inputStream = connection.getErrorStream();

            }

            retorno = converterInputStreamToString(inputStream);
            inputStream.close();
            connection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;

    }

    private static String converterInputStreamToString(InputStream is) {

        StringBuffer buffer = new StringBuffer();

        try {

            BufferedReader br;
            String linha;


            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();


    }


    public static String doPost(String url, String postContent) {
        String retorno = "";

        try {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection connection;
            InputStream inputStream;

            connection = (HttpURLConnection) apiEnd.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            PrintStream ps = new PrintStream(os);

            ps.print(postContent);
            ps.close();

            connection.connect();

            codigoResposta = connection.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = connection.getInputStream();

            } else {
                inputStream = connection.getErrorStream();

            }

            retorno = converterInputStreamToString(inputStream);
            os.close();
            connection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;


    }

}