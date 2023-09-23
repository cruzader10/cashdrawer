package com.example.virtualcashdrawer;

import android.os.Bundle;

import java.io.Serializable;

public class Drawer implements Serializable {

    private String drawer;
   // private int image;

    public Drawer(){

    }

    public  String getDrawer(){return drawer;}
    public void setName(String drawer){this.drawer = drawer;}
    //public int getImage(){return image;}
    //public void setImage(int image){this.image = image;}
}
