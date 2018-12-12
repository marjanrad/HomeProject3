package com.example.marjanraad.homeproject3;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button  btnRegister ;
    TextView showTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        String name= PreferenceManager.getDefaultSharedPreferences(this).getString("NAME","welcome to shop");
        showTv.setText("Welcome "+name);

      btnRegister.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
              startActivity(intent);
          }
      });




    }

    private void init() {


        btnRegister=findViewById(R.id.mainRegister);
        showTv=findViewById(R.id.mainTv);

    }

}
