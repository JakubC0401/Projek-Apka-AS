package com.example.multifunctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button StopwatchButton ;
    private Button CalculatorButton;
    private Button NoteButton;
    private Button TTTButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StopwatchButton=(Button)findViewById(R.id.StopwatchBtn);
        StopwatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TurnOnStopwatchActivity();
            }
        });

        CalculatorButton=(Button)findViewById(R.id.CalculatorBtn);
        CalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                TurnOnCalculatorActivity();
            }
        });

        NoteButton=(Button)findViewById(R.id.NotesBtn);
        NoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                TurnOnNotesActivity();
            }
        });

        TTTButton=(Button)findViewById(R.id.PlayGame);
        TTTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                TurnOnTicTacToeActivity();
            }
        });

    }
    public void TurnOnStopwatchActivity(){
        Intent intent=new Intent(this,StopwatchActivity.class);
        startActivity(intent);
    }
    public void TurnOnCalculatorActivity(){
        Intent intent= new Intent(this,Calc.class);
        startActivity(intent);

    }
    public void TurnOnNotesActivity(){

        Intent intent=new Intent(this,NotesActivity.class);
        startActivity(intent);
    }
    public void TurnOnTicTacToeActivity(){
        Intent intent=new Intent(this,TicTacToeActivity.class);
        startActivity(intent);
    }
}
