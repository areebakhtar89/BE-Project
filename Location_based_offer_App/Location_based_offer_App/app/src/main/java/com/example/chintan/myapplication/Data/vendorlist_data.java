package com.example.chintan.myapplication.Data;

import java.util.ArrayList;

public class vendorlist_data {
    public static ArrayList<String> vendor_id,vname,vcontact,vlocation,vdescription,vlongitude,vlatitude,cat_id,rate;

    public static ArrayList<String> getVendor_id() {
        return vendor_id;
    }

    public static ArrayList<String> getVcontact() {
        return vcontact;
    }

    public static void setVcontact(ArrayList<String> vcontact) {
        vendorlist_data.vcontact = vcontact;
    }

    public static ArrayList<String> getVlocation() {
        return vlocation;
    }

    public static void setVlocation(ArrayList<String> vlocation) {
        vendorlist_data.vlocation = vlocation;
    }

    public static ArrayList<String> getVdescription() {
        return vdescription;
    }

    public static void setVdescription(ArrayList<String> vdescription) {
        vendorlist_data.vdescription = vdescription;
    }

    public static ArrayList<String> getCat_id() {
        return cat_id;
    }

    public static void setCat_id(ArrayList<String> cat_id) {
        vendorlist_data.cat_id = cat_id;
    }

    public static ArrayList<String> getRate() {
        return rate;
    }

    public static void setRate(ArrayList<String> rate) {
        vendorlist_data.rate = rate;
    }

    public static void setVendor_id(ArrayList<String> vendor_id) {
        vendorlist_data.vendor_id = vendor_id;
    }



    public static ArrayList<String> getVname() {
        return vname;
    }

    public static void setVname(ArrayList<String> vname) {
        vendorlist_data.vname = vname;
    }

    public static ArrayList<String> getVlongitude() {
        return vlongitude;
    }

    public static void setVlongitude(ArrayList<String> vlongitude) {
        vendorlist_data.vlongitude = vlongitude;
    }

    public static ArrayList<String> getVlatitude() {
        return vlatitude;
    }

    public static void setVlatitude(ArrayList<String> vlatitude) {
        vendorlist_data.vlatitude = vlatitude;
    }




}
