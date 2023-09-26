package com.example.endevinaelnumero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editTextNumber);
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resp = Integer.parseInt(String.valueOf(editText.getText()));
                int duration = Toast.LENGTH_SHORT;


                TextView tw = findViewById(R.id.textView);
                tw.setText(Integer.toString(num));

                Toast toast = Toast.makeText(getApplicationContext(),"Default",duration);
                if (resp == num) {
                    toast = Toast.makeText(getApplicationContext(),"Correcte!",duration);
                } else if (resp >= 101 || resp <= 0) {
                    toast = Toast.makeText(getApplicationContext(),"Error, el numero ha d'estar entre 1-100",duration);
                } else if (resp < num) {
                    toast = Toast.makeText(getApplicationContext(),"El numero es major",duration);
                } else if (resp > num) {
                    toast = Toast.makeText(getApplicationContext(), "El numero es menor", duration);
                } else {
                    toast = Toast.makeText(getApplicationContext(),"Error",duration);
                }
                toast.show();
            }
        });

        findViewById(R.id.buttonDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("¡¡Felicitats!!");
                builder.setMessage("Has encertat el numero, torna a jugar!");

                builder.setPositiveButton("Perfecto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                });
            }
        });


    }
}