package com.i190405_i190404.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Signup extends AppCompatActivity {
    Button signin,signup;
    EditText name;
    EditText password;
    EditText email;
    ImageView malegen;
    ImageView femalegen;
    ImageView prefernottosaygen;
    String genderr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        name=findViewById(R.id.Name);
        password=findViewById(R.id.pass);
        email=findViewById(R.id.email);
        malegen=findViewById(R.id.malegender);
        femalegen=findViewById(R.id.femalegender);
        prefernottosaygen=findViewById(R.id.prefernottosaygender);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,Signin.class);
                startActivity(intent);
            }
        });

        malegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genderr="male";
                System.out.println("genderrrr");
            }
        });

        femalegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genderr="female";
                System.out.println("genderrrr");
            }
        });
        prefernottosaygen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genderr="prefer not to say";
                System.out.println("genderrrr");
            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nam,pass,em,gen;
                nam=name.getText().toString();
                pass=password.getText().toString();
                em=email.getText().toString();
                gen=genderr;

                if(!nam.equals("") && !em.equals("") && !pass.equals("") && !gen.equals("") ) {

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {


                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "email";
                            field[2] = "password";
                            field[3] = "gender";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = nam;
                            data[1] = em;
                            data[2] = pass;
                            data[3] = gen;

                            PutData putData = new PutData("http://192.168.18.19/loginregister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(),Signin.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });

                }
                else{

                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }

            }
        });


        //Start ProgressBar first (Set visibility VISIBLE)

    }
}