package com.example.isuru.sltaxi;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class DriverLoginActivity extends AppCompatActivity {

    private Button Driverlogbtn;
    private Button Driverregbtn;
    private TextView Driverstatus;
    private TextView Driverregisterlink;
    private EditText driveremail;
    private EditText driverpw;
    private FirebaseAuth mAuth;
    private ProgressDialog processbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        mAuth = FirebaseAuth.getInstance();


        Driverlogbtn = findViewById(R.id.Driverlog_btn);
        Driverregbtn = findViewById(R.id.Driverregi_btn);
        Driverstatus = findViewById(R.id.Driver_status);
        Driverregisterlink = findViewById(R.id.Driverregister_link);

        driveremail = findViewById(R.id.driver_email);
        driverpw = findViewById(R.id.driver_pw);

        processbar = new ProgressDialog(this);

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

        Driverregbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = driveremail.getText().toString();
                String password =driverpw.getText().toString();

                RegisterDriver(email,password);
            }
        });

        Driverlogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void RegisterDriver(String email, String password) {

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(DriverLoginActivity.this, "Please Enter Your Email..",Toast.LENGTH_SHORT).show();

        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(DriverLoginActivity.this, "Please Enter Your Password..",Toast.LENGTH_SHORT).show();

        }
        else {

            processbar.setTitle("Driver Registration");
            processbar.setMessage("Please Wait we are Registering You..");
            processbar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)

                        {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(DriverLoginActivity.this, "Driver Register Successfull", Toast.LENGTH_SHORT).show();
                                    processbar.dismiss();
                                }
                                else {

                                    Toast.makeText(DriverLoginActivity.this, "Driver Register Unsuccessfull", Toast.LENGTH_SHORT).show();
                                    processbar.dismiss();
                                }
                        }
                    });

        }

    }
}
