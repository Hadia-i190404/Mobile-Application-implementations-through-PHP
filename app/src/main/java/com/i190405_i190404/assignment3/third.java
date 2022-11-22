package com.i190405_i190404.assignment3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class third extends AppCompatActivity {
    TextView name;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        name=findViewById(R.id.name);
        message=findViewById(R.id.message);
        name.setText(getIntent().getStringExtra("nam"));
        message.setText(getIntent().getStringExtra("msg"));

    }



}
