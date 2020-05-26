package com.example.multifunctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {

    public Button[][] buttons= new Button[3][3];
    private boolean player1Turn=true;
    int round;
    int p1Points,p2Points;

    private TextView tx1;
    private TextView tx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        tx1=(TextView)findViewById(R.id.tv_p1);
        tx2=(TextView)findViewById(R.id.tv_p2);



        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String IdButton="button_"+i+j;
                int resID=getResources().getIdentifier(IdButton,"id",getPackageName());
                buttons[i][j]=findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button restartButton=findViewById(R.id.resetBtn);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals("")){
            return;
        }
        if(player1Turn){
            ((Button)v).setText("X");
        }
        else{
            ((Button)v).setText("O");
        }
        round++;
        if(isWin()){
            if(player1Turn){
                player1Wins();
            }
            else {
                player2Wins();
            }
        }
        else if(round==9){
            itDraw();
        }
        else {
            player1Turn=!player1Turn;
        }
    }

    private void itDraw() {
        Toast.makeText(this,"draw",Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void player2Wins() {
        p2Points++;
        Toast.makeText(this,"player 2 wins",Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }

    private void player1Wins() {
        p1Points++;
        Toast.makeText(this,"player 1 wins", Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }

    private void updatePoints() {
        tx1.setText("Player 1: "+p1Points);
        tx2.setText("Player 2: "+p2Points);

    }
    private void resetBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setText("");
            }
        }
    }

    private boolean isWin(){
        String[][]field=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j]=buttons[i][j].getText().toString();
            }
        }
        for(int i=0;i<3;i++){
            if(field[i][0].equals(field[i][1])&&field[i][0].equals(field[i][2])&&!field[i][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(field[0][i].equals(field[1][i])&&field[0][i].equals(field[2][i])&&!field[0][i].equals("")){
                return true;
            }
        }
        if(field[0][0].equals(field[1][1])&&field[0][0].equals(field[2][2])&&!field[0][0].equals("")){
            return true;
        }
        if(field[0][2].equals(field[1][1])&&field[0][2].equals(field[2][0])&&!field[0][2].equals("")){
            return true;
        }
        return false;
    }

}
