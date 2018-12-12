package com.example.marjanraad.homeproject3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister, btnReset, btnDrawer ;
    EditText inputName , inputAge , inputWeb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        String name=  PreferenceManager.getDefaultSharedPreferences(this).getString("NAME","");
        String age=  PreferenceManager.getDefaultSharedPreferences(this).getString("AGE","");
        String web=  PreferenceManager.getDefaultSharedPreferences(this).getString("WEB","");

        inputName.setText(name);
        inputAge.setText(age);
        inputWeb.setText(web);



        //set register button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=inputName.getText().toString().trim();
                String age=inputAge.getText().toString().trim();
                String webSite=inputWeb.getText().toString().trim();

                //send info to Show

                Intent intent=new Intent(getApplicationContext(),ShowInfoDialog.class);
                intent.putExtra("NAME",name);
                intent.putExtra("AGE",age);
                intent.putExtra("WEBSITE",webSite);
                startActivity(intent);
            }
        });


        //set reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("NAME","").apply();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("AGE","").apply();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("WEB","").apply();

                inputName.setText("");
                inputAge.setText("");
                inputWeb.setText("");



            }
        });

        btnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final AlertDialog alertDialog=new AlertDialog.Builder(RegisterActivity.this).create();
                alertDialog.setMessage("Exit");
                alertDialog.setMessage("Are you sure for exit? ");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();

                Toast.makeText(RegisterActivity.this, "exit", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        btnRegister = findViewById(R.id.registeRegister);
        btnReset =findViewById(R.id.registerReset);
        inputName=findViewById(R.id.registerName);
        inputAge=findViewById(R.id.registerAge);
        inputWeb=findViewById(R.id.registerWeb);
        btnDrawer=findViewById(R.id.drawer_exit);

    }

}
