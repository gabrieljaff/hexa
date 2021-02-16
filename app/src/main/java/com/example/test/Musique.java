//Activité musique//

package com.example.test;


import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
//import android.widget.CompoundButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.billthefarmer.mididriver.MidiDriver;
import org.billthefarmer.mididriver.MidiConstants;
import org.billthefarmer.mididriver.GeneralMidiConstants;
import org.billthefarmer.mididriver.ReverbConstants;

import java.util.Locale;

public class Musique extends AppCompatActivity
        implements View.OnTouchListener ,View.OnClickListener/*,
        CompoundButton.OnCheckedChangeListener*/,
        MidiDriver.OnMidiStartListener
{
    private TextView text;

    protected MidiDriver midi;
    protected MediaPlayer player;

    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique);

        // Create midi driver
        midi = new MidiDriver();

        // Set on touch listener
        View v = findViewById(R.id.activity_musique_do);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_re);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_mi);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_fa);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_sol);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_la);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_si);
        if (v != null)
            v.setOnTouchListener(this);


        v = findViewById(R.id.activity_musique_drum);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_musique_snare);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_musique_hithat);
        if (v != null)
            v.setOnClickListener(this);
       /* v = findViewById(R.id.activity_musique_la);
        if (v != null)
            v.setOnClickListener(this);

        v = findViewById(R.id.activity_musique_re);
        if (v != null)
            v.setOnClickListener(this);*/

       /* v = findViewById(R.id.activity_musique_mi);
        if (v != null)
            ((CompoundButton) v).setOnCheckedChangeListener(this);*/

     //   text = findViewById(R.id.status);

        // Set on midi start listener
        if (midi != null)
            midi.setOnMidiStartListener(this);
    }

    // On resume
    @Override
    protected void onResume()
    {
        super.onResume();

        // Start midi

        if (midi != null)
            midi.start();
    }

    // On pause
    @Override
    protected void onPause()
    {
        super.onPause();

        // Stop midi
        if (midi != null)
            midi.stop();

        // Stop player
        if (player != null)
            player.stop();
    }

    // On touch
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int action = event.getAction();
        int id = v.getId();

        switch (action) {
            // Down
            case MotionEvent.ACTION_DOWN:
                switch (id) {
                    case R.id.activity_musique_do:
                        sendMidi(0x91, 60, 63);
                        sendMidi(0x91, 64, 63);
                        sendMidi(0x91, 67, 63);
                        break;

                    case R.id.activity_musique_re:
                        sendMidi(0x91, 62, 63);
                        sendMidi(0x91, 65, 63);
                        sendMidi(0x91, 69, 63);
                        break;

                    case R.id.activity_musique_mi:
                        sendMidi(0x91, 64, 63);
                        sendMidi(0x91, 67, 63);
                        sendMidi(0x91, 71, 63);
                        break;

                    case R.id.activity_musique_fa:
                        sendMidi(0x91, 65, 63);
                        sendMidi(0x91, 69, 63);
                        sendMidi(0x91, 72, 63);
                        break;

                    case R.id.activity_musique_sol:
                        sendMidi(0x91, 67, 63);
                        sendMidi(0x91, 71, 63);
                        sendMidi(0x91, 74, 63);
                        break;

                    case R.id.activity_musique_la:
                        sendMidi(0x91, 69, 63);
                        sendMidi(0x91, 72, 63);
                        sendMidi(0x91, 76, 63);
                        break;

                    case R.id.activity_musique_si:
                        sendMidi(0x91, 71, 63);
                        sendMidi(0x91, 74, 63);
                        sendMidi(0x91, 87, 63);
                        break;

                    default:
                        return false;
                }

                v.performClick();
                break;

            // Up
            case MotionEvent.ACTION_UP:
                switch (id) {
                    case R.id.activity_musique_do:
                        sendMidi(MidiConstants.NOTE_ON, 60, 0);
                        sendMidi(MidiConstants.NOTE_ON, 64, 0);
                        sendMidi(MidiConstants.NOTE_ON, 67, 0);
                        break;

                    case R.id.activity_musique_re:
                        sendMidi(MidiConstants.NOTE_ON, 62, 0);
                        sendMidi(MidiConstants.NOTE_ON, 65, 0);
                        sendMidi(MidiConstants.NOTE_ON, 69, 0);
                        break;

                    case R.id.activity_musique_mi:
                        sendMidi(MidiConstants.NOTE_ON, 64, 0);
                        sendMidi(MidiConstants.NOTE_ON, 67, 0);
                        sendMidi(MidiConstants.NOTE_ON, 71, 0);
                        break;

                    case R.id.activity_musique_fa:
                        sendMidi(MidiConstants.NOTE_ON, 65, 0);
                        sendMidi(MidiConstants.NOTE_ON, 69, 0);
                        sendMidi(MidiConstants.NOTE_ON, 72, 0);
                        break;

                    case R.id.activity_musique_sol:
                        sendMidi(MidiConstants.NOTE_ON, 67, 0);
                        sendMidi(MidiConstants.NOTE_ON, 71, 0);
                        sendMidi(MidiConstants.NOTE_ON, 74, 0);
                        break;

                    case R.id.activity_musique_la:
                        sendMidi(MidiConstants.NOTE_ON, 69, 0);
                        sendMidi(MidiConstants.NOTE_ON, 72, 0);
                        sendMidi(MidiConstants.NOTE_ON, 76, 0);
                        break;

                    case R.id.activity_musique_si:
                        sendMidi(MidiConstants.NOTE_ON, 71, 0);
                        sendMidi(MidiConstants.NOTE_ON, 74, 0);
                        sendMidi(MidiConstants.NOTE_ON, 87, 0);
                        break;

                    default:
                        return false;
                }
                break;

            default:
                return false;
        }

        return false;
    }

    // On click
    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id) {
            case R.id.activity_musique_drum:
                sendMidi(0x99, 36, 100);
                break;

            case R.id.activity_musique_snare:
                sendMidi(0x99, 40, 100);
                break;

            case R.id.activity_musique_hithat:
                sendMidi(0x99, 42, 100);
                break;
        }
    }
  /*  @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id) {
            case R.id.activity_musique_la:
                if (player != null) {
                    player.stop();
                    player.release();
                }

                player = MediaPlayer.create(this, R.raw.ants);
                player.start();
                break;

            case R.id.activity_musique_re:
                if (player != null)
                    player.stop();
                break;
        }
    }*/

    // onCheckedChanged
   /* @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if (isChecked)
            midi.setReverb(ReverbConstants.CHAMBER);

        else
            midi.setReverb(ReverbConstants.OFF);
    }*/

    // Listener for sending initial midi messages when the Sonivox
    // synthesizer has been started, such as program change.
    @Override
    public void onMidiStart()
    {
        // Program change - harpsichord
        sendMidi(MidiConstants.PROGRAM_CHANGE,
                GeneralMidiConstants.HARPSICHORD);

        // Get the config
        int config[] = midi.config();

        //String format = getString(R.string.format);
        //String info = String.format(Locale.getDefault(), format, config[0],
                //config[1], config[2], config[3]);

       // if (text != null)
        //    text.setText(info);
    }

    // Send a midi message, 2 bytes
    protected void sendMidi(int m, int n)
    {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) n;

        midi.write(msg);
    }

    // Send a midi message, 3 bytes
    protected void sendMidi(int m, int n, int v)
    {
        byte msg[] = new byte[3];

        msg[0] = (byte) m;
        msg[1] = (byte) n;
        msg[2] = (byte) v;

        midi.write(msg);
    }
}