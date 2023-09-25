package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editTextNumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resp = Integer.parseInt(String.valueOf(editText.getText()));
                int duration = Toast.LENGTH_SHORT;
                int num = 10;

                Toast toast = Toast.makeText(getApplicationContext(),"Default",duration);
                if (resp == num) {
                    toast = Toast.makeText(getApplicationContext(),"Correcte!",duration);
                } if (resp > num) {
                    toast = Toast.makeText(getApplicationContext(),"El respero es menor",duration);
                } if (resp < num) {
                    toast = Toast.makeText(getApplicationContext(),"El numero es major",duration);
                } else {
                    toast = Toast.makeText(getApplicationContext(), "Error", duration);
                }
                toast.show();
            }
        });



    }
}