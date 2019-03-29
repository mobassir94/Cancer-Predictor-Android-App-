package com.example.cancerpredictor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.cer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent cervical = new Intent(MainActivity.this,cervicalcancer.class);

                startActivity(cervical);



            }
        });


        btn1 = findViewById(R.id.ova);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ovarian = new Intent(MainActivity.this,ovariancancer.class);



                startActivity(ovarian);



            }
        });



    }
}
