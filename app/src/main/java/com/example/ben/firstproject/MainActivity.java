package com.example.ben.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Switch;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public final String[] numbers = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public int numberValue = 0;

    private int random = new Random().nextInt(7);

    public String currentString = numbers[numberValue];

    // TODO misha - added a comment to check git workings... delete it
    public boolean capital = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.textView);
        Button randomButton = (Button)findViewById(R.id.button);
        Button nextButton = (Button)findViewById(R.id.button2);
        Switch switchCapital = (Switch)findViewById(R.id.switch1);
        Button previousButton = (Button)findViewById(R.id.button3);

        switchCapital.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    capital = true;
                    text.setText(currentString.toUpperCase());
                }else{
                    capital = false;
                    text.setText(currentString.toLowerCase());
                }
            }
        });

        randomButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        random = new Random().nextInt(26);
                        numberValue = random;
                        currentString = numbers[numberValue];
                        if(capital) {
                            text.setText(currentString.toUpperCase());
                        }else{
                            text.setText(currentString);
                        }
                    }
                }
        );

        previousButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(numberValue > 0){
                            numberValue--;
                        }else if(numberValue == 0){
                            numberValue = 25;
                        }
                        currentString = numbers[numberValue];
                        if(capital) {
                            text.setText(currentString.toUpperCase());
                        }else{
                            text.setText(currentString);
                        }
                    }
                }
        );

        nextButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(numberValue < 25){
                            numberValue ++;
                        }else if(numberValue == 25){
                            numberValue = 0;
                        }
                        currentString = numbers[numberValue];
                        if(capital) {
                            text.setText(currentString.toUpperCase());
                        }else{
                            text.setText(currentString);
                        }
                    }
                }
        );

    }

}
