package com.example.multifunctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calc extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero,Bdivide,Bmultiplication,Bclear,Bresults,Bplus,Bminus,Bdot;
    EditText edt1;
    float result1,result2;
    boolean add,min,multi,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        zero=(Button)findViewById(R.id.btn0);
        Bdivide=(Button)findViewById(R.id.btnDivide);
        Bmultiplication=(Button)findViewById(R.id.btnMulti);
        Bclear=(Button)findViewById(R.id.btnC);
        Bresults=(Button)findViewById(R.id.btnResult);
        Bplus=(Button)findViewById(R.id.btnPlus);
        Bminus=(Button)findViewById(R.id.btnMinus);
        Bdot=(Button)findViewById(R.id.btnDot);
        edt1=(EditText)findViewById(R.id.editText2);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"0");
            }
        });
        Bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+".");
            }
        });
        Bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1==null){
                    edt1.setText("");
                }
                else {
                    result1=Float.parseFloat(edt1.getText()+"");
                    add=true;
                    edt1.setText(null);

                }
            }
        });
        Bmultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1==null){
                    edt1.setText("");
                }
                else {
                    result1=Float.parseFloat(edt1.getText()+"");
                    multi=true;
                    edt1.setText(null);
                }
            }
        });
        Bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1==null){
                    edt1.setText("");
                }
                else {
                    result1=Float.parseFloat(edt1.getText()+"");
                    min=true;
                    edt1.setText(null);
                }
            }
        });
        Bdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1==null){
                    edt1.setText("");
                }
                else {
                    result1=Float.parseFloat(edt1.getText()+"");
                    div=true;
                    edt1.setText(null);
                }
            }
        });
        Bresults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result2=Float.parseFloat(edt1.getText()+"");
                if(add==true){
                    edt1.setText(result1+result2+"");
                    add=false;
                }
                if(min==true){
                    edt1.setText(result1-result2+"");
                    min=false;
                }
                if(multi==true){
                    edt1.setText(result1*result2+"");
                    multi=false;
                }
                if(div==true){
                    edt1.setText(result1/result2+"");
                    div=false;
                }
            }
        });
        Bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
            }
        });
    }
}
