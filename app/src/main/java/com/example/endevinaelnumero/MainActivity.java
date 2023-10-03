package com.example.endevinaelnumero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Record> Records = new ArrayList<Record>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final Button playAgainButton = findViewById(R.id.changeRandomButton);
        final Button rankingButton = findViewById(R.id.rankingButton);
        final EditText editText = findViewById(R.id.editTextNumber);
        final int[] num = {this.getRandomNumber()};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(),"Default",duration);
                String r = String.valueOf(editText.getText());
                if (r.equals("")){
                    toast = Toast.makeText(getApplicationContext(),"Error",duration);
                    toast.show();
                } else {
                    int resp = Integer.parseInt(r);


                    TextView tw = findViewById(R.id.textView);
                    tw.setText(Integer.toString(num[0]));


                    if (resp == num[0]) {
                        exectuteDialog();
                        playAgainButton.setVisibility(View.VISIBLE);
                    } else if (resp >= 101 || resp <= 0) {
                        toast = Toast.makeText(getApplicationContext(), "Error, el numero ha d'estar entre 1-100", duration);
                        toast.show();
                    } else if (resp < num[0]) {
                        toast = Toast.makeText(getApplicationContext(), "El numero es major", duration);
                        toast.show();
                    } else {
                        toast = Toast.makeText(getApplicationContext(), "El numero es menor", duration);
                        toast.show();
                    }
                }
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num[0] = getRandomNumber();
                playAgainButton.setVisibility(View.INVISIBLE);
            }
        });

        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRankings();
            }
        });

    }


    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private void exectuteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("¡¡Felicitats!!");
        builder.setMessage("Has encertat el numero, vols desar la teva puntuacio al ranking? Posa el nom amb el que es guardara la puntuacio!");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String value = String.valueOf(input.getText());

                goToRankings();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });


        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void goToRankings() {
        Intent goRankings = new Intent(getApplicationContext(), RankingActivity.class);
        startActivity(goRankings);
    }

}