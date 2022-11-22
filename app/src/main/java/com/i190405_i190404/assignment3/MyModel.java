package com.i190405_i190404.assignment3;

import android.graphics.Bitmap;

public class MyModel {

    String name,message;
    Bitmap dp;
    public Bitmap getDp() {
        return dp;
    }

    public void setDp(Bitmap dp) {
        this.dp = dp;
    }


    public MyModel(String name,String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}
