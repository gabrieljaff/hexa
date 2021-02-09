//Activité musique//

package com.example.test;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.billthefarmer.mididriver.MidiDriver;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;

import org.billthefarmer.mididriver.MidiConstants;
import org.billthefarmer.mididriver.GeneralMidiConstants;
//import java.io.File;
// import  android.media.midi.MidiDevice; https://source.android.com/devices/audio/midi
//https://developer.android.com/reference/android/media/midi/package-summary
// autre alternative : https://stackoverflow.com/questions/36193250/android-6-0-marshmallow-how-to-play-midi-notes
//voir fonctionnement fichiers midi et media driver


public class Musique extends AppCompatActivity implements MidiDriver.OnMidiStartListener,


        View.OnTouchListener {

    protected MidiDriver midiDriver;
    protected MediaPlayer player;

    private byte[] event;
    private int[] config;
    //déclaration des boutons notes
    private Button Do;
   /* private Button Re;
    private Button Mi;
    private Button Fa;
    private Button Sol;
    private Button La;
    private Button Si;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique);
        MediaPlayer.create(this, R.raw.ants);
        Do= (Button) findViewById(R.id.activity_musique_do);
       /* Re= (Button) findViewById(R.id.activity_musique_re);
        Mi= (Button) findViewById(R.id.activity_musique_mi);
        Fa= (Button) findViewById(R.id.activity_musique_fa);
        Sol= (Button) findViewById(R.id.activity_musique_sol);
        La= (Button) findViewById(R.id.activity_musique_la);
        Si= (Button) findViewById(R.id.activity_musique_si);*/
        Do.setOnTouchListener(this);
       /* Re.setOnTouchListener(this);
        Mi.setOnTouchListener(this);
        Fa.setOnTouchListener(this);
        Sol.setOnTouchListener(this);
        La.setOnTouchListener(this);
        Si.setOnTouchListener(this);*/

        // Instantiate the driver.
        midiDriver = new MidiDriver();
        // Set the listener.
        midiDriver.setOnMidiStartListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        midiDriver.start();

        // Get the configuration.
        config = midiDriver.config();

        // Print out the details.
        Log.d(this.getClass().getName(), "maxVoices: " + config[0]);
        Log.d(this.getClass().getName(), "numChannels: " + config[1]);
        Log.d(this.getClass().getName(), "sampleRate: " + config[2]);
        Log.d(this.getClass().getName(), "mixBufferSize: " + config[3]);
    }




    @Override
    protected void onPause() {
        super.onPause();
        midiDriver.stop();
    }

    @Override
    public void onMidiStart() {
        Log.d(this.getClass().getName(), "onMidiStart()");
    }

    private void playNote() {

        // Construct a note ON message for the middle C at maximum velocity on channel 1:
        event = new byte[3];
        event[0] = (byte) (MidiConstants.NOTE_ON );  // 0x90 = note On, 0x00 = channel 1
        event[1] = (byte) 0x3C;  // 0x3C = middle C
        event[2] = (byte) 0x7F;  // 0x7F = the maximum velocity (127)

        // Internally this just calls write() and can be considered obsoleted:
        //midiDriver.queueEvent(event);

        // Send the MIDI event to the synthesizer.
        midiDriver.write(event);

    }

    private void stopNote() {

        // Construct a note OFF message for the middle C at minimum velocity on channel 1:
        event = new byte[3];
        event[0] = (byte) (0x80 |0x00);  // 0x80 = note Off, 0x00 = channel 1
        event[1] = (byte) 0x3C;  // 0x3C = middle C
        event[2] = (byte) 0x00;  // 0x00 = the minimum velocity (0)

        // Send the MIDI event to the synthesizer.
        midiDriver.write(event);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.d(this.getClass().getName(), "Motion event: " + event);

        if (v.getId() == R.id.La) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");

                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }
        if (v.getId() == R.id.Si) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }
        if (v.getId() == R.id.Do) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                MediaPlayer.create(this, R.raw.ants);
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
                player.release();
            }
        }
        if (v.getId() == R.id.Re) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }
        if (v.getId() == R.id.Mi) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }


        if (v.getId() == R.id.Fa) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }


        if (v.getId() == R.id.Sol) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
                playNote();
                player.start();
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
                stopNote();
                player.stop();
            }
        }

        return false;
    }
}
   /*
public class Musique extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        //création de l'activité
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique);

        //affiliation des boutons à l'interface graphique
        Do= (Button) findViewById(R.id.activity_musique_do);
        Re= (Button) findViewById(R.id.activity_musique_re);
        Mi= (Button) findViewById(R.id.activity_musique_mi);
        Fa= (Button) findViewById(R.id.activity_musique_fa);
        Sol= (Button) findViewById(R.id.activity_musique_sol);
        La= (Button) findViewById(R.id.activity_musique_la);
        Si= (Button) findViewById(R.id.activity_musique_si);
        //end

        //implémentation fichier midi

        //fin imp midi

        //affiliation des boutons aux clique et aux différentes notes
        Fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        Do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        La.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
    //déclaration des boutons notes
    private Button Do;
    private Button Re;
    private Button Mi;
    private Button Fa;
    private Button Sol;
    private Button La;
    private Button Si;
}*/
