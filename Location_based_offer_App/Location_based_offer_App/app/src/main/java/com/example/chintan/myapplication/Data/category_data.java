package com.example.chintan.myapplication.Data;

import java.util.ArrayList;

public class category_data {
    public static ArrayList<String> cat_id,category_name;

    public static ArrayList<String> getCat_id() {
        return cat_id;
    }

    public static void setCat_id(ArrayList<String> cat_id) {
        category_data.cat_id = cat_id;
    }

    public static ArrayList<String> getCategory_name() {
        return category_name;
    }

    public static void setCategory_name(ArrayList<String> category_name) {
        category_data.category_name = category_name;
    }
}
