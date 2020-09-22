package com.example.chintan.myapplication.Data;

public class selected_cat {
    public static int cat_id;
    public static String cat_name;
    public static  String single_catid;

    public static String getSingle_catname() {
        return single_catname;
    }

    public static void setSingle_catname(String single_catname) {
        selected_cat.single_catname = single_catname;
    }

    public static String single_catname;


    public static String getSingle_catid() {
        return single_catid;
    }

    public static void setSingle_catid(String single_catid) {
        selected_cat.single_catid = single_catid;
    }

    public static int getCat_id() {
        return cat_id;
    }

    public static void setCat_id(int cat_id) {
        selected_cat.cat_id = cat_id;
    }

    public static String getCat_name() {
        return cat_name;
    }

    public static void setCat_name(String cat_name) {
        selected_cat.cat_name = cat_name;
    }
}
