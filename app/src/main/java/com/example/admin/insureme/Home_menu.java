package com.example.admin.insureme;

import java.util.ArrayList;

/**
 * Created by Admin on 23/03/2017.
 */

public class Home_menu {
    public String image;
    public String title;
    public ArrayList<String> child_items = new ArrayList<String>();
    public Home_menu(String title){
        this.title = title;
    }
    @Override
    public String toString(){
        return title;
    }
}
