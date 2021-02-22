//Activité musique//

package com.example.test;


import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import org.billthefarmer.mididriver.MidiDriver;
import org.billthefarmer.mididriver.MidiConstants;
import org.billthefarmer.mididriver.GeneralMidiConstants;
import org.billthefarmer.mididriver.ReverbConstants;

public class Config extends AppCompatActivity
        implements View.OnTouchListener ,View.OnClickListener,
        MidiDriver.OnMidiStartListener {

    protected MidiDriver midi;
    public int lp_ctrl=0;
    public int debut_lp=0;
    public long loop[][]=new long[30][2];
    public long song;
    public int cpt_lp;

    public long duree_lp;

    public long startTime=0 ;
    public long endTime=0;

    public long clk;
//couleur bouton loop
    int colorloop = Color.rgb(58, 137, 35);
    int colorloopgri = Color.rgb(0, 86, 27);
    int colornbloop = Color.rgb(0,191,255);
//activation/ désactivation de la loop
    private static boolean lp_actif=false;
    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

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
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_snare);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_hithat);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_percu_4);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_percu_5);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_percu_6);
        if (v != null)
            v.setOnTouchListener(this);


        v = findViewById(R.id.activity_musique_nb_loop);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_loop);
        if (v != null)
            v.setOnTouchListener(this);

        v = findViewById(R.id.activity_musique_config);
        if (v != null)
            v.setOnClickListener(this);


        //dom min
        if (MainActivity.ton==0){
            ((Button)findViewById(R.id.activity_musique_fa)).setText("Fa");
            ((Button)findViewById(R.id.activity_musique_do)).setText("Do");
            ((Button)findViewById(R.id.activity_musique_sol)).setText("Sol");
            ((Button)findViewById(R.id.activity_musique_re)).setText("Rém");
            ((Button)findViewById(R.id.activity_musique_la)).setText("Lam");
            ((Button)findViewById(R.id.activity_musique_mi)).setText("Mim");
            ((Button)findViewById(R.id.activity_musique_si)).setText("Sidim7");
        }

        //Ré maj
        if ( MainActivity.ton==1) {
            ((Button) findViewById(R.id.activity_musique_fa)).setText("Sol");
            ((Button) findViewById(R.id.activity_musique_do)).setText("Ré");
            ((Button) findViewById(R.id.activity_musique_sol)).setText("La");
            ((Button) findViewById(R.id.activity_musique_re)).setText("Mim");
            ((Button) findViewById(R.id.activity_musique_la)).setText("Sim");
            ((Button) findViewById(R.id.activity_musique_mi)).setText("Fa#m");
            ((Button) findViewById(R.id.activity_musique_si)).setText("Do#");
        }
        //set couleur bouton loop
        ((Button)findViewById(R.id.activity_musique_loop)).setBackgroundColor(colorloop);
        ((Button)findViewById(R.id.activity_musique_nb_loop)).setBackgroundColor(colornbloop);
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
                        if(MainActivity.ton==0){
                        sendMidi(MidiConstants.NOTE_ON, 60, 40);
                        sendMidi(MidiConstants.NOTE_ON, 64, 40);
                        sendMidi(MidiConstants.NOTE_ON, 67, 40);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_ON, 62, 40);
                            sendMidi(MidiConstants.NOTE_ON, 66, 40);
                            sendMidi(MidiConstants.NOTE_ON, 69, 40);
                        }
                        break;

                    case R.id.activity_musique_re:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_ON, 62, 40);
                            sendMidi(MidiConstants.NOTE_ON, 65, 40);
                            sendMidi(MidiConstants.NOTE_ON, 69, 40);
                        }
                        if(MainActivity.ton==1) {
                            sendMidi(MidiConstants.NOTE_ON, 64, 40);
                            sendMidi(MidiConstants.NOTE_ON, 67, 40);
                            sendMidi(MidiConstants.NOTE_ON, 71, 40);
                        }
                        break;

                    case R.id.activity_musique_mi:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_ON, 64, 40);
                            sendMidi(MidiConstants.NOTE_ON, 67, 40);
                            sendMidi(MidiConstants.NOTE_ON, 71, 40);
                        }
                        if(MainActivity.ton==1) {
                            sendMidi(MidiConstants.NOTE_ON, 66, 40);
                            sendMidi(MidiConstants.NOTE_ON, 69, 40);
                            sendMidi(MidiConstants.NOTE_ON, 73, 40);
                        }
                        break;

                    case R.id.activity_musique_fa:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_ON, 65, 40);
                            sendMidi(MidiConstants.NOTE_ON, 69, 40);
                            sendMidi(MidiConstants.NOTE_ON, 72, 40);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_ON, 67, 40);
                            sendMidi(MidiConstants.NOTE_ON, 71, 40);
                            sendMidi(MidiConstants.NOTE_ON, 76, 40);
                        }
                            break;

                     case R.id.activity_musique_sol:
                         if(MainActivity.ton==0) {
                                sendMidi(MidiConstants.NOTE_ON, 67, 40);
                                sendMidi(MidiConstants.NOTE_ON, 71, 40);
                                sendMidi(MidiConstants.NOTE_ON, 74, 40);
                        }
                         if(MainActivity.ton==1){
                             sendMidi(MidiConstants.NOTE_ON, 69, 40);
                             sendMidi(MidiConstants.NOTE_ON, 73, 40);
                             sendMidi(MidiConstants.NOTE_ON, 76, 40);
                         }
                        break;

                    case R.id.activity_musique_la:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_ON, 69, 40);
                            sendMidi(MidiConstants.NOTE_ON, 72, 40);
                            sendMidi(MidiConstants.NOTE_ON, 76, 40);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_ON, 71, 40);
                            sendMidi(MidiConstants.NOTE_ON, 74, 40);
                            sendMidi(MidiConstants.NOTE_ON, 78, 40);
                        }
                        break;

                    case R.id.activity_musique_si:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_ON, 71, 40);
                            sendMidi(MidiConstants.NOTE_ON, 74, 40);
                            sendMidi(MidiConstants.NOTE_ON, 77, 40);
                            sendMidi(MidiConstants.NOTE_OFF, 80, 40);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_ON, 61, 40);
                            sendMidi(MidiConstants.NOTE_ON, 66, 40);
                            sendMidi(MidiConstants.NOTE_ON, 68, 40);
                        }
                        //sendMidi(0x91, 80, 40);
                        break;

                    case R.id.activity_musique_drum:
                        song=36;
                        sendMidi(0x99, 36, 100);
                        break;

                    case R.id.activity_musique_snare:
                        song=40;
                        sendMidi(0x99, 40, 100);
                        break;

                    case R.id.activity_musique_hithat:
                        song=42;
                        sendMidi(0x99, 42, 100);
                        break;

                    case R.id.activity_musique_percu_4:
                        song=39;
                        sendMidi(0x99, 39, 100);
                        break;

                    case R.id.activity_musique_percu_5:
                        song=49;
                        sendMidi(0x99, 49, 100);
                        break;

                    case R.id.activity_musique_percu_6:
                        song=46;
                        sendMidi(0x99, 46, 100);
                        break;
//signal loop débute
                    case R.id.activity_musique_loop:
                        if (lp_ctrl==0){
                            if (lp_actif==false) {
                                lp_ctrl = 1;
                                ((Button) findViewById(R.id.activity_musique_loop)).setBackgroundColor(colorloopgri);
                            }
                        }
//signal loop se termine
                        else if (debut_lp==1){
                            lp_ctrl=0;
                            debut_lp=0;
                            endTime=System.currentTimeMillis();
                            duree_lp=endTime-startTime;
                            loop[cpt_lp][1]=duree_lp;
                            ((Button)findViewById(R.id.activity_musique_loop)).setBackgroundColor(colorloop);

                           if (lp_actif==false) {
                               lp_actif = true;
                               //on active la loop dans un thread parallèle
                               new Thread(new Runnable() {
                                   public void run() {
                                       loop_launch(duree_lp, loop);
                                   }
                               }).start();
                               ((Button) findViewById(R.id.activity_musique_nb_loop)).setText("1");
                           }
                           cpt_lp=0;
                        }
                        else {
                            lp_ctrl=0;
                            debut_lp=0;
                            ((Button)findViewById(R.id.activity_musique_loop)).setBackgroundColor(colorloop);
                        }
                        break;
                    case R.id.activity_musique_nb_loop:
                        lp_actif=false;
                        ((Button)findViewById(R.id.activity_musique_nb_loop)).setText("0");
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
                        if(MainActivity.ton==0){
                            sendMidi(MidiConstants.NOTE_OFF, 60, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 64, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 67, 0);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_OFF, 62, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 66, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                        }
                        break;

                    case R.id.activity_musique_re:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 62, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 65, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                        }
                        if(MainActivity.ton==1) {
                            sendMidi(MidiConstants.NOTE_OFF, 64, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 67, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                        }
                        break;

                    case R.id.activity_musique_mi:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 64, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 67, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                        }
                        if(MainActivity.ton==1) {
                            sendMidi(MidiConstants.NOTE_OFF, 66, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 73, 0);
                        }
                        break;

                    case R.id.activity_musique_fa:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 65, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 72, 0);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_OFF, 67, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 76, 0);
                        }
                        break;

                    case R.id.activity_musique_sol:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 67, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 74, 0);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 73, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 76, 0);
                        }
                        break;

                    case R.id.activity_musique_la:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 69, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 72, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 76, 0);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 74, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 78, 0);
                        }
                        break;

                    case R.id.activity_musique_si:
                        if(MainActivity.ton==0) {
                            sendMidi(MidiConstants.NOTE_OFF, 71, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 74, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 77, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 80, 0);
                        }
                        if(MainActivity.ton==1){
                            sendMidi(MidiConstants.NOTE_OFF, 61, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 66, 0);
                            sendMidi(MidiConstants.NOTE_OFF, 68, 0);
                        }

                        break;
                    default:
                        return false;
                }
                break;

            default:
                return false;
        }
//gestion d'acquisition de la loop
        if  ((id==R.id.activity_musique_drum||id==R.id.activity_musique_hithat||id==R.id.activity_musique_snare||id==R.id.activity_musique_percu_4||id==R.id.activity_musique_percu_5||id==R.id.activity_musique_percu_6) && lp_ctrl==1 && debut_lp==0) {
            debut_lp=1;
            startTime= System.currentTimeMillis();
        }
        if (debut_lp==1) {
            loop[cpt_lp][0]=song;
            endTime=System.currentTimeMillis();
            clk=endTime-startTime;
            loop[cpt_lp][1]=clk;
            cpt_lp++;
            //sécurité (ne pas dépasser la taille de loop)
            if (cpt_lp==29) {
                lp_ctrl=0;
                debut_lp=0;
                endTime=System.currentTimeMillis();
                duree_lp=endTime-startTime;
                ((Button)findViewById(R.id.activity_musique_loop)).setBackgroundColor(colorloop );
                loop_launch(duree_lp,loop);
                cpt_lp=0;
            }
        }
        //fin gestion acquisition loop
        return false;
    }

    // On click
    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id) {


            case R.id.activity_musique_config:
                Intent intentconfig = new Intent(Config.this, MainActivity.class);
                startActivity(intentconfig);
                break;
        }
    }

    @Override

    public void onMidiStart()
    {
        // Program change - harpsichord
        sendMidi(MidiConstants.PROGRAM_CHANGE,
                GeneralMidiConstants.SHAKUHACHI);


        midi.setReverb(MainActivity.rev);

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

    //lancer la boucle

    protected void loop_launch(long duree,long part[][])
    {
        Handler handler = new Handler();

        long tps_reel;
        long temp;
        int cpt;
        while (Config.lp_actif==true)
        {
            cpt=0;
            temp=part[cpt][1];
            tps_reel=0;
            while ((tps_reel<duree)&&Config.lp_actif==true)
            {
                SystemClock.sleep(temp);
                sendMidi(0x99, (int)part[cpt][0], 100);
                tps_reel+=temp;
                cpt++;
                temp=part[cpt][1]-tps_reel;
                /*Log.d("debugx","cpt"+cpt);
                Log.d("debugx","temp : "+temp);
                Log.d("debugx","duree : "+duree);
                Log.d("debugx","temps réel : "+tps_reel);
                Log.d("debugx","-------------------------------------");*/

            }
        }
    }

}
