package com.i190405_i190404.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Homescreen extends AppCompatActivity {
    RecyclerView rv;
    List<MyModel> ls;
    MyAdapter adapter;
    ImageView add;
    TextView name;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        rv=findViewById(R.id.rv);
        add=findViewById(R.id.add);
        name=findViewById(R.id.name);
        message=findViewById(R.id.message);
        ls=new ArrayList<>();
        ls.add(new MyModel("Hello","message"));
        adapter=new MyAdapter(ls,Homescreen.this);
        rv.setAdapter(adapter);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(Homescreen.this);
        rv.setLayoutManager(lm);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homescreen.this,ADD.class);
                startActivityForResult(intent,1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                String nam=data.getStringExtra("nam");
                String msg=data.getStringExtra("msg");
                MyModel m=new MyModel(nam,msg);
                ls.add(m);
                adapter=new MyAdapter(ls,Homescreen.this);
                rv.setAdapter(adapter);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(Homescreen.this);
                rv.setLayoutManager(lm);
            }

        }
    }
}