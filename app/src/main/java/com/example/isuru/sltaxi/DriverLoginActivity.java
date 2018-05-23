package com.example.isuru.sltaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverLoginActivity extends AppCompatActivity {

    private Button Driverlogbtn;
    private Button Driverregbtn;
    private TextView Driverstatus;
    private TextView Driverregisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);


        Driverlogbtn = findViewById(R.id.Driverlog_btn);
        Driverregbtn = findViewById(R.id.Driverregi_btn);
        Driverstatus = findViewById(R.id.Driver_status);
        Driverregisterlink = findViewById(R.id.Driverregister_link);

        Driverregbtn.setVisibility(View.INVISIBLE);
        Driverregbtn.setEnabled(false);

        Driverregisterlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Driverlogbtn.setVisibility(View.INVISIBLE);
                Driverregbtn.setVisibility(View.INVISIBLE);
                Driverstatus.setText("Register Driver");
                Driverregbtn.setVisibility(View.VISIBLE);
                Driverregbtn.setEnabled(true);


            }
        });

    }
}
