package com.example.test;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import org.billthefarmer.mididriver.ReverbConstants;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    static public int ton = 0;
    static public int rev= ReverbConstants.OFF;


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

        v = findViewById(R.id.activity_config_reverb_0);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_reverb_1);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_reverb_2);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_reverb_3);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_reverb_4);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_1);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_2);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_3);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_4);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_5);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_percu_6);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_config_instrument);
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

            case R.id.activity_config_reverb_0 :
                rev= ReverbConstants.OFF;
                ((Button)findViewById(R.id.activity_config_reverb_0)).setBackgroundColor(Color.GRAY);
                ((Button)findViewById(R.id.activity_config_reverb_1)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_2)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_3)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_4)).setBackgroundColor(Color.WHITE);

                break;

            case R.id.activity_config_reverb_1 :
                rev= ReverbConstants.ROOM;
                ((Button)findViewById(R.id.activity_config_reverb_1)).setBackgroundColor(Color.GRAY);
                ((Button)findViewById(R.id.activity_config_reverb_0)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_2)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_3)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_4)).setBackgroundColor(Color.WHITE);
                break;

            case R.id.activity_config_reverb_2 :
                rev= ReverbConstants.CHAMBER;
                ((Button)findViewById(R.id.activity_config_reverb_2)).setBackgroundColor(Color.GRAY);
                ((Button)findViewById(R.id.activity_config_reverb_1)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_0)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_3)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_4)).setBackgroundColor(Color.WHITE);
                break;

            case R.id.activity_config_reverb_3 :
                rev= ReverbConstants.HALL;
                ((Button)findViewById(R.id.activity_config_reverb_3)).setBackgroundColor(Color.GRAY);
                ((Button)findViewById(R.id.activity_config_reverb_1)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_2)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_0)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_4)).setBackgroundColor(Color.WHITE);
                break;

            case R.id.activity_config_reverb_4 :
                rev= ReverbConstants.LARGE_HALL;
                ((Button)findViewById(R.id.activity_config_reverb_4)).setBackgroundColor(Color.GRAY);
                ((Button)findViewById(R.id.activity_config_reverb_1)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_2)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_3)).setBackgroundColor(Color.WHITE);
                ((Button)findViewById(R.id.activity_config_reverb_0)).setBackgroundColor(Color.WHITE);
                break;

            case R.id.activity_config_percu_1:
                break;

            case R.id.activity_config_percu_2:
                break;

            case R.id.activity_config_percu_3:
                break;

            case R.id.activity_config_percu_4:
                break;

            case R.id.activity_config_percu_5:
                break;

            case R.id.activity_config_percu_6:
                break;

            case R.id.activity_config_instrument:
                Intent intentinstrument = new Intent(MainActivity.this, SelectionInstrument.class);
                startActivity(intentinstrument);
                break;

        }
    }
}