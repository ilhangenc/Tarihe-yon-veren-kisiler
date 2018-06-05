package com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss.Model.Kisi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ilhangenc on 31.5.2018.
 */

public class TarihBugun extends AppCompatActivity {

    HttpHandler httpHandler;
    TextView olumtext,dogumtext,olaytext;
    private static String URL = "https://raw.githubusercontent.com/ilhangenc/Kaynak/master/kisiler.json";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarihbugun);
        new getRecipe().execute();


    }


    private class getRecipe extends AsyncTask<Void, Void, Void> {
        ArrayList<Kisi> kisiArrayList = new ArrayList<>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        public Void doInBackground(Void... params) {
            httpHandler = new HttpHandler();



            String jsonString = httpHandler.makeservicecall(URL);
            Log.d("JSON_RESPONSE", jsonString);

            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray kisiler = jsonObject.getJSONArray("kisiler");

                for (int i = 0; i < kisiler.length(); i++) {
                    JSONObject kisi = kisiler.getJSONObject(i);

                    String kisiID = kisi.getString("kisiid");
                    String kisiAdi = kisi.getString("kisiadi");
                    String kisiHayat = kisi.getString("kisihayat");
                    String kisiResim = kisi.getString("kisiresim");

                    Kisi ks = new Kisi(kisiID,kisiAdi,kisiHayat,kisiResim);

                    kisiArrayList.add(ks);

                }

            } catch (Exception e) {
            }


            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            olaytext=(TextView)findViewById(R.id.olaytext);





            olaytext.setText(kisiArrayList.get(0).getKisiId());




        }


    }
}
