package com.i190405_i190404.assignment3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<MyModel> ls;
    Context c;

    public MyAdapter(List<MyModel> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //this generates a row hence
        View row= LayoutInflater.from(c).inflate(R.layout.row,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(ls.get(position).getName());
        holder.message.setText(ls.get(position).getmessage());
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(c,third.class);
                intent.putExtra("nam",holder.name.getText().toString());
                intent.putExtra("msg",holder.message.getText().toString());
                c.startActivity(intent);
               // Intent i=new Intent();
                //c.startActivity();
                Toast.makeText(c,position+"",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,message;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            message=itemView.findViewById(R.id.message);

        }
    }
}

