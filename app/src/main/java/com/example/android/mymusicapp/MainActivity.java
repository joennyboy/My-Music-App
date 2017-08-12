package com.example.android.mymusicapp;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.mymusicapp.R.id.btnPlaylist;

public class MainActivity extends Activity {
    public static int oneTimeOnly = 0;
    private Button b1, b2, b3, b4, b5, b6;
    private ImageView iv;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1, tx2, tx3;
    public Runnable updateSongTime = new Runnable() {
        public void run() {
            // get current position
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime))));
            //set seekbar progressA

            myHandler.postDelayed(this, 100);
        }

    };

    //Update Timer on seekbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);


        iv = (ImageView) findViewById(R.id.image);

        tx1 = (TextView) findViewById(R.id.textView2);
        tx2 = (TextView) findViewById(R.id.textView3);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer = MediaPlayer.create(this, R.raw.song2);

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setClickable(true);
        b2.setEnabled(true);
        // when the play button is clicked
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Playing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();



                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                tx1.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );
                seekbar.setProgress((int) startTime);


                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });
        //when the pause button is clicked
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(true);
                b3.setEnabled(true);
            }
        });
        //when the forward button is clicked

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),
                            "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //when rewind button is clicked
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),
                            "You have Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b6 = (Button) findViewById(btnPlaylist);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new intent for opening order via email
                Intent intent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(intent);
                //creating sending message toast
                Toast.makeText(getApplicationContext(),
                        "Compiling Playlist", Toast.LENGTH_SHORT).show();

            }
        });

        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new intent for opening order via email
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
                //creating sending message toast
                Toast.makeText(getApplicationContext(),
                        "Sending Order", Toast.LENGTH_SHORT).show();
            }


        });
    }

}













