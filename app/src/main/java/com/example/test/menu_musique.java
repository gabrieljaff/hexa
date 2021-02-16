package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_musique extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_musique);


        View v = findViewById(R.id.menu_musique_accords);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.menu_musique_notes);
        if (v != null)
            v.setOnClickListener( this);
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id) {
            case R.id.menu_musique_accords:
                Intent intentmusique = new Intent(menu_musique.this, Musique.class);
                startActivity(intentmusique);
                break;

            case R.id.menu_musique_notes:
                Intent intentnotes = new Intent(menu_musique.this, Musique_notes.class);
                startActivity(intentnotes);
                break;
        }
    }
}