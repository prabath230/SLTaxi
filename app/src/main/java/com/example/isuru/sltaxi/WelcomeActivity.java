package com.example.isuru.sltaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity

     {
         private Button custermer_btn ;
         private Button driver_btn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        custermer_btn = findViewById(R.id.custermer_btn);
        driver_btn = findViewById(R.id.driver_btn);

        custermer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent CustomorloginactivityIntent = new Intent(WelcomeActivity.this, CustomorLoginActivity.class );
                startActivity(CustomorloginactivityIntent);
            }
        });

        driver_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent DriverloginactivityIntent = new Intent(WelcomeActivity.this, DriverLoginActivity.class );
                startActivity(DriverloginactivityIntent);
            }
        });




    }
}
