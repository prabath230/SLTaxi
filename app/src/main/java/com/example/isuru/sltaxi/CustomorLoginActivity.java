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

public class CustomorLoginActivity extends AppCompatActivity {

    private Button customorlogbtn;
    private Button customorregbtn;
    private TextView customorstatus;
    private TextView customorloglink;
    private EditText customeremail;
    private EditText customorpw;
    private FirebaseAuth mAuth;
    private ProgressDialog processbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customor_login);

        mAuth = FirebaseAuth.getInstance();

        customorlogbtn = findViewById(R.id.customorlog_btn);
        customorregbtn = findViewById(R.id.customorreg_btn);
        customorstatus = findViewById(R.id.customor_status);
        customorloglink = findViewById(R.id.customorlog_link);
        customeremail = findViewById(R.id.customer_email);
        customorpw = findViewById(R.id.customor_pw);

        processbar = new ProgressDialog(this);

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

        customorregbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = customeremail.getText().toString();
                String password =customorpw.getText().toString();

                RegisterCustomer(email,password);
            }
        });
         customorlogbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String email = customeremail.getText().toString();
                 String password =customorpw.getText().toString();

                 LoginCustemor(email,password);
             }
         });

    }

    private void LoginCustemor(String email, String password) {


        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(CustomorLoginActivity.this, "Please Enter Your Email..",Toast.LENGTH_SHORT).show();

        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(CustomorLoginActivity.this, "Please Enter Your Password..",Toast.LENGTH_SHORT).show();

        }
        else {

            processbar.setTitle("Customer Login");
            processbar.setMessage("Please Wait we are Login You..");
            processbar.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)

                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(CustomorLoginActivity.this, "Customer Login is Successfull", Toast.LENGTH_SHORT).show();
                                processbar.dismiss();
                            }
                            else {

                                Toast.makeText(CustomorLoginActivity.this, "Customer Login is Unsuccessfull", Toast.LENGTH_SHORT).show();
                                processbar.dismiss();
                            }
                        }
                    });

        }
    }

    private void RegisterCustomer(String email, String password) {


        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(CustomorLoginActivity.this, "Please Enter Your Email..",Toast.LENGTH_SHORT).show();

        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(CustomorLoginActivity.this, "Please Enter Your Password..",Toast.LENGTH_SHORT).show();

        }
        else {

            processbar.setTitle("Customer Registration");
            processbar.setMessage("Please Wait we are Registering You..");
            processbar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)

                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(CustomorLoginActivity.this, "Customer Register Successfull", Toast.LENGTH_SHORT).show();
                                processbar.dismiss();
                            }
                            else {

                                Toast.makeText(CustomorLoginActivity.this, "Customer Register Unsuccessfull", Toast.LENGTH_SHORT).show();
                                processbar.dismiss();
                            }
                        }
                    });

        }
    }
}
