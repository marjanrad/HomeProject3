package com.example.marjanraad.homeproject3;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowInfoDialog extends AppCompatActivity {

    TextView showName , showAge , showWeb ;
    Button btnConfirm , btnChange ;
    String name , age , webSite ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_dialog);

        init();

        Intent intent=getIntent();
         name = intent.getStringExtra("NAME");
         age = intent.getStringExtra("AGE");
         webSite = intent.getStringExtra("WEBSITE");

        showName.setText(name);
        showAge.setText(age);
        showWeb.setText(webSite);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("NAME",name).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("AGE",age).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("WEB",webSite).apply();

                Intent sendFile=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(sendFile);
                finish();


            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
//                startActivity(intent);

                finish();
            }
        });
        showWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),WebViewActivity.class);
                intent.putExtra("WEBURL" , webSite);
                startActivity(intent);

            }
        });
    }

    private void init() {
        showName=findViewById(R.id.showInfoName);
        showAge=findViewById(R.id.showInfoAge);
        showWeb=findViewById(R.id.showInfoWebSite);
        btnConfirm=findViewById(R.id.showInfoConfirm);
        btnChange=findViewById(R.id.showInfoChange);
    }
}
