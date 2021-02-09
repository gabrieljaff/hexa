// Activité page d'acceuil//
//git@github.com:gabrieljaff/hexapad_appli.git
package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //création de l'activité principale
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //end

        //affiliation des boutons à l'interface graphique
        bouton1= (Button) findViewById(R.id.activity_main_btn1);
        bouton2= (Button) findViewById(R.id.activity_main_btn2);
        //end

        //affiliatition de changemant d'activité vers Musique avec intéraction bouton 1
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent intentsampler = new Intent(MainActivity.this, Sampler.class);
                startActivity(intentsampler);
            }
        });
        //end

        //
        //affiliatition de changemant d'activité vers Sample avec bouton 2
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent intentmusique = new Intent(MainActivity.this, Musique.class);
                startActivity(intentmusique);
            }
        });
        //end
    }

    // déclaration des boutons
    private Button bouton1;
    private Button bouton2;
}
