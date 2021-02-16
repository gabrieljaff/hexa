package com.example.test;


import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;


import org.billthefarmer.mididriver.MidiDriver;
import org.billthefarmer.mididriver.MidiConstants;
import org.billthefarmer.mididriver.GeneralMidiConstants;
// référence percution : https://www.midi.org/specifications-old/item/gm-level-1-sound-set
// ref fréquence : https://andymurkin.files.wordpress.com/2012/01/midi-int-midi-note-no-chart.jpg
// ressources message midi :http://midi.teragonaudio.com/tech/midispec/noteoff.htm
        //https://getzen.pagesperso-orange.fr/norme.htm#Messages
        //http://www.arpegemusique.com/manuel36/FR400.htm
public class Musique_notes extends AppCompatActivity
        implements View.OnTouchListener , View.OnClickListener,
        MidiDriver.OnMidiStartListener {

    protected MidiDriver midi;
    protected MediaPlayer player;

    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique_notes);

        // Create midi driver
        midi = new MidiDriver();

        // Set on touch listener
        View v = findViewById(R.id.activity_musique_notes_do);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_sol);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_re);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_la);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_mi);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_si);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_notes_solb);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_reb);
        if (v != null)
            v.setOnTouchListener(this);
        v = findViewById(R.id.activity_musique_notes_lab);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_notes_mib);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_notes_sib);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_notes_fa);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_notes_drum);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.activity_musique_notes_snare);
        if (v != null)
            v.setOnClickListener(this);
        v = findViewById(R.id.activity_musique_notes_hithat);
        if (v != null)
            v.setOnClickListener(this);
        // Set on midi start listener
        if (midi != null)
            midi.setOnMidiStartListener(this);
    }

    // On resume
    @Override
    protected void onResume() {
        super.onResume();

        // Start midi

        if (midi != null)
            midi.start();
    }

    // On pause
    @Override
    protected void onPause() {
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
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        int id = v.getId();

        switch (action) {
            // Down
            case MotionEvent.ACTION_DOWN:
                switch (id) {
                    case R.id.activity_musique_notes_do:
                        sendMidi(0x91, 24, 63);

                        break;

                    case R.id.activity_musique_notes_sol:
                        sendMidi(0x91, 31, 63);
                        break;

                    case R.id.activity_musique_notes_re:
                        sendMidi(0x91, 38, 63);
                        break;

                    case R.id.activity_musique_notes_la:
                        sendMidi(0x91, 45, 63);
                        break;

                    case R.id.activity_musique_notes_mi:
                        sendMidi(0x91, 52, 63);
                        break;

                    case R.id.activity_musique_notes_si:
                        sendMidi(0x91, 59, 63);
                        break;

                    case R.id.activity_musique_notes_solb:
                        sendMidi(0x91, 66, 63);
                        break;

                    case R.id.activity_musique_notes_reb:
                        sendMidi(0x91, 73, 63);
                        break;

                    case R.id.activity_musique_notes_lab:
                        sendMidi(0x91, 80, 63);
                        break;

                    case R.id.activity_musique_notes_mib:
                        sendMidi(0x91, 87, 63);
                        break;

                    case R.id.activity_musique_notes_sib:
                        sendMidi(0x91, 94, 63);
                        break;

                    case R.id.activity_musique_notes_fa:
                        sendMidi(0x91, 101, 63);
                        break;

                    default:
                        return false;
                }

                v.performClick();
                break;

            // Up
            case MotionEvent.ACTION_UP:
                switch (id) {
                    case R.id.activity_musique_notes_do:
                        sendMidi(MidiConstants.NOTE_ON, 0, 0);
                        break;

                    case R.id.activity_musique_notes_sol:
                        sendMidi(MidiConstants.NOTE_ON, 7, 0);
                        break;

                    case R.id.activity_musique_notes_re:
                        sendMidi(MidiConstants.NOTE_ON, 14, 0);
                        break;

                    case R.id.activity_musique_notes_la:
                        sendMidi(MidiConstants.NOTE_ON, 21, 0);
                        break;

                    case R.id.activity_musique_notes_mi:
                        sendMidi(MidiConstants.NOTE_ON, 28, 0);
                        break;

                    case R.id.activity_musique_notes_si:
                        sendMidi(MidiConstants.NOTE_ON, 35, 0);
                        break;

                    case R.id.activity_musique_notes_solb:
                        sendMidi(MidiConstants.NOTE_ON, 42, 0);
                        break;

                    case R.id.activity_musique_notes_reb:
                        sendMidi(MidiConstants.NOTE_ON, 49, 0);
                        break;

                    case R.id.activity_musique_notes_lab:
                        sendMidi(MidiConstants.NOTE_ON, 56, 0);
                        break;

                    case R.id.activity_musique_notes_mib:
                        sendMidi(MidiConstants.NOTE_ON, 63, 0);
                        break;

                    case R.id.activity_musique_notes_sib:
                        sendMidi(MidiConstants.NOTE_ON, 70, 0);
                        break;

                    case R.id.activity_musique_notes_fa:
                        sendMidi(MidiConstants.NOTE_ON, 77, 0);
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

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id) {
            case R.id.activity_musique_notes_drum:
                sendMidi(0x99, 36, 100);
                break;

            case R.id.activity_musique_notes_snare:
                sendMidi(0x99, 40, 100);
                break;

            case R.id.activity_musique_notes_hithat:
                sendMidi(0x99, 42, 100);
                break;
        }
    }

    // Listener for sending initial midi messages when the Sonivox
    // synthesizer has been started, such as program change.
    @Override
    public void onMidiStart() {
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
    protected void sendMidi(int m, int n) {
        byte msg[] = new byte[2];

        msg[0] = (byte) m;
        msg[1] = (byte) n;

        midi.write(msg);
    }

    // Send a midi message, 3 bytes
    protected void sendMidi(int m, int n, int v) {
        byte msg[] = new byte[3];

        msg[0] = (byte) m;
        msg[1] = (byte) n;
        msg[2] = (byte) v;

        midi.write(msg);
    }
}