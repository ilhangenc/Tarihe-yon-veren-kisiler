package com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ilhangenc on 26.4.2018.
 */
//jsson verilerini alan sınıf
public class HttpHandler {

    public HttpHandler(){}


    public String makeservicecall(String requestUrl){
        String response=null;



        try {
            URL url=new URL(requestUrl);

            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in= new BufferedInputStream(connection.getInputStream());
            response =convertStreamToString(in);

        }catch (MalformedURLException e){

        }catch (IOException e){

        }




        return response;
    }


    private String convertStreamToString(InputStream is){
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        StringBuilder ab=new StringBuilder();

        String satir="";


        try{
            while((satir = reader.readLine()) != null){
                ab.append(satir).append("\n");
            }

        }catch (IOException e){

        }finally {
            {
                try{
                    is.close();

                }catch (IOException e){

                }
            }
        }

        return ab.toString();

    }
}