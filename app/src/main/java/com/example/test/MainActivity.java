package com.example.test;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    static public int ton = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v = findViewById(R.id.activity_config_do);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_re);
        if (v != null)
            v.setOnClickListener(this);



        v = findViewById(R.id.activity_config_apply);
        if (v != null)
            v.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.activity_config_do :
                ton = 0 ;

                ((Button)findViewById(R.id.activity_config_re)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_do)).setBackgroundColor(Color.GRAY);
                break;
            case R.id.activity_config_re :
                ton = 1 ;
                ((Button)findViewById(R.id.activity_config_do)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_re)).setBackgroundColor(Color.GRAY);
                break;

            case R.id.activity_config_apply :
                    Intent intentdomaj = new Intent(MainActivity.this, Config.class);
                    startActivity(intentdomaj);

                break;

        }
    }
}