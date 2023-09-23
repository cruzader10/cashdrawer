package com.example.virtualcashdrawer;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Drawer> getDrawerList() {
        List<Drawer> drawerList = new ArrayList<>();

        Drawer Drawer1 = new Drawer();
        Drawer1.setName("Drawer 1");
        drawerList.add(Drawer1);

        Drawer Drawer2 = new Drawer();
        Drawer2.setName("Drawer 2");
        drawerList.add(Drawer2);

        Drawer Drawer3 = new Drawer();
        Drawer3.setName("Drawer 3");
        drawerList.add(Drawer3);

        Drawer Drawer4 = new Drawer();
        Drawer4.setName("General");
        drawerList.add(Drawer4);


        return drawerList;
    }
}
