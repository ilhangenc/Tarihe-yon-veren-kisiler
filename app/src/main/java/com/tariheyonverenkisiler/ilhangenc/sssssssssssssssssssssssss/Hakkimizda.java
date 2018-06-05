package com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ilhangenc on 23.4.2018.
 */

public class Hakkimizda extends AppCompatActivity{

    Button facebutton,twitterbutton;
    Context context=this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hakkimizda);

        facebutton=(Button) findViewById(R.id.facebutton);
        twitterbutton=(Button)findViewById(R.id.twitterbutton);




        //bizi takip edin bölümünde facebook'a yönlendirme.
        facebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.facebook.com/ilhangnc61");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);


            }
        });
        //bizi takip edin bölümünde twitter'a yönlendirme.
        twitterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://twitter.com/ilhngnc");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });


    }



}
