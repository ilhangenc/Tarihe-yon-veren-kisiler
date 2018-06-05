package com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.tariheyonverenkisiler.ilhangenc.sssssssssssssssssssssssss.Model.Kisi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Tab1.OnFragmentInteractionListener, Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener {

    Context context = this;
    HttpHandler httpHandler;
    TextView sporttext, sportisim, bilimisim1, bilimtext1, sanatisim, sanattext,olaytext;


    //json verilerinin çekileceği adres
    private static String URL = "https://raw.githubusercontent.com/ilhangenc/Kaynak/master/kisiler.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Nav();
        Tab();
        new getRecipe().execute();





    }


   //Drawer Navigation böllümü
    public void Nav(){

        //DrawerNavigation  işelmleri
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Drawer Navigatioın son


    }

    // Tabbed sınıflarını işlemleri
    public void Tab() {
        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);

        //fragmentlerin tanımlanması
        tablayout.addTab(tablayout.newTab().setText("SPOR"));
        tablayout.addTab(tablayout.newTab().setText("KÜLTÜR-SANAT"));
        tablayout.addTab(tablayout.newTab().setText("BİLİM"));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    //Drawer Navigation menüsü item işlemleri
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.tarihtebugun) {

            Intent intent=new Intent(context,TarihBugun.class);
            startActivity(intent);



        } else if (id == R.id.iletisim) {
            Intent intent=new Intent(context,Form_class.class);
            startActivity(intent);

        } else if (id == R.id.hakkımızda) {
            Intent intent=new Intent(context,Hakkimizda.class);
            startActivity(intent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    //Json parse işlemleri
    private class getRecipe extends AsyncTask<Void, Void, Void> {
        ArrayList<Kisi> kisiArrayList = new ArrayList<>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        public Void doInBackground(Void... params) {
            httpHandler = new HttpHandler();


            //httphandler classından makeservicecall metodu ile belirilen url den json verilerini çekiyoruz.
            String jsonString = httpHandler.makeservicecall(URL);
            Log.d("JSON_RESPONSE", jsonString);

            try {

                //json verileri jsonOBject olarak alınıp string'e çeviriliyor.
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray kisiler = jsonObject.getJSONArray("kisiler");

                for (int i = 0; i < kisiler.length(); i++) {
                    JSONObject kisi = kisiler.getJSONObject(i);

                    String kisiID = kisi.getString("kisiid");
                    String kisiAdi = kisi.getString("kisiadi");
                    String kisiHayat = kisi.getString("kisihayat");
                    String kisiResim = kisi.getString("kisiresim");

                    //yeni kişi oluşturuyoruz
                    Kisi ks = new Kisi(kisiID,kisiAdi,kisiHayat,kisiResim);

                    //oluşturulan kişiyi arraylist'e atıyoruz.
                    kisiArrayList.add(ks);

                }

            } catch (Exception e) {
            }

            return null;


        }


        //array listeteki verileri textview değerlerine atıyoruz.
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            sporttext = (TextView) findViewById(R.id.sportext);
            sportisim = (TextView) findViewById(R.id.sportisim);
            sanatisim = (TextView) findViewById(R.id.sanatisim);
            sanattext = (TextView) findViewById(R.id.sanattext);
            bilimisim1 = (TextView) findViewById(R.id.bilimisim1);
            bilimtext1 = (TextView) findViewById(R.id.bilimtext1);
            //olaytext=(TextView)findViewById(R.id.olaytext);

            sportisim.setText(kisiArrayList.get(0).getKisiAdi());
            sporttext.setText(kisiArrayList.get(0).getKisiHayat());
            sanatisim.setText(kisiArrayList.get(1).getKisiAdi());
            sanattext.setText(kisiArrayList.get(1).getKisiHayat());


        }


    }








}
