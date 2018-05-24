package com.example.isuru.sltaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomorLoginActivity extends AppCompatActivity {

    private Button customorlogbtn;
    private Button customorregbtn;
    private TextView customorstatus;
    private TextView customorloglink;
    private EditText customeremail;
    private EditText customorpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customor_login);

        customorlogbtn = findViewById(R.id.customorlog_btn);
        customorregbtn = findViewById(R.id.customorreg_btn);
        customorstatus = findViewById(R.id.customor_status);
        customorloglink = findViewById(R.id.customorlog_link);
        customeremail = findViewById(R.id.customer_email);
        customorpw = findViewById(R.id.customor_pw);

        customorregbtn.setVisibility(View.INVISIBLE);
        customorregbtn.setEnabled(false);



        customorloglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customorlogbtn.setVisibility(View.INVISIBLE);
                customorregbtn.setVisibility(View.INVISIBLE);
                customorstatus.setText("Register Customer");
                customorregbtn.setVisibility(View.VISIBLE);
                customorregbtn.setEnabled(true);


            }
        });
    }
}
