package com.i190405_i190404.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Signin extends AppCompatActivity {

    Button signin,signup;
    EditText name;
    EditText password;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin);
        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        password=findViewById(R.id.pass);
        email=findViewById(R.id.email);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signin.this,Signup.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass, em;
                pass = password.getText().toString();
                em = email.getText().toString();


                if (!em.equals("") && !pass.equals("")) {

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = em;
                            data[1] = pass;
                            PutData putData = new PutData("http://192.168.18.19/loginregister/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Homescreen.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)

                                }
                            }
                            //End Write and Read data with URL


                        }


                    });

                }
                else

                {

                    Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                }

            }
        });

        }

}





