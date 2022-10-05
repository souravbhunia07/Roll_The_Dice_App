package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);

        int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyDiceApp", "BtnRoll is tapped now!");

                Random rndObject = new Random();     // create random number

                int myRandomNumber = rndObject.nextInt(6);    // 0 .. 6
                int myRandomNumber1 = rndObject.nextInt(6);    // 0 .. 6

                Log.i("Table", myRandomNumber + "");
                Log.i("Table", myRandomNumber1 + "");

                diceImage1.setImageResource(diceImages[myRandomNumber]);
                diceImage2.setImageResource(diceImages[myRandomNumber1]);

                YoYo.with(Techniques.Shake)
                        .duration(400)     // 1000 -> 1s
                        .repeat(0)
                        .playOn(diceImage1);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);

                mp.start();
            }
        });
    }
}