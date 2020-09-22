package com.example.chintan.myapplication.ConnectionM;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.chintan.myapplication.Data.Existingofferdata;
import com.example.chintan.myapplication.Data.Location_;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.Userdata;
import com.example.chintan.myapplication.Data.category_data;
import com.example.chintan.myapplication.Data.insertofferdetails;
import com.example.chintan.myapplication.Data.selectcategory_data;
import com.example.chintan.myapplication.Data.selected_cat;
import com.example.chintan.myapplication.Data.selectrange;
import com.example.chintan.myapplication.Data.vendorlist_data;
import com.example.chintan.myapplication.PreferencesClass;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class Connection {

   /* public static String localurl = "http://192.168.1.38/Locationbased_ads/Service1.svc/";*/

    public static String localurl = "http://my-demo.in/Locationbased_Ads_service/Service1.svc/";

    //public static String localurl = "http://192.168.0.100/LocbasedAdsApp/Service1.svc/";



   SharedPreferences sharedPreferences;

    public static boolean checkNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }


    public int register() {
        try {
            final String TAG_id = "Msg";
            StringBuilder result = new StringBuilder();

            HttpClient httpclient = new DefaultHttpClient();
            String url = String.format(localurl + "signuppost");
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("name", Userdata.getName());
            jsonObject.accumulate("emailid", Userdata.getEmail());
            jsonObject.accumulate("contact", Userdata.getContact());
            jsonObject.accumulate("address", Userdata.getAddress());
            jsonObject.accumulate("password", Userdata.getPassword());
            jsonObject.accumulate("repassword", Userdata.getRepassword());

            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jobj = new JSONObject(result.toString());
                String msg = jobj.getString(TAG_id);

                if (msg.equals("Data inserted")) {

                    return 1;

                } else if (msg.equals("Emailid and contact already exist")) {
                    return 2;
                } else {
                    return 3;
                }
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }

        } catch (Exception e) {
            return 0;
        }
    }
    public int rate() {
        try {
            final String TAG_id = "Msg";
            StringBuilder result = new StringBuilder();

            HttpClient httpclient = new DefaultHttpClient();
            String url = String.format(localurl + "getrate");
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("user_id", Userdata.getUserid());
            jsonObject.accumulate("vendor_id",selectcategory_data.getVendor_id());
            jsonObject.accumulate("rate", selectcategory_data.getRate());


            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jobj = new JSONObject(result.toString());
                String msg = jobj.getString(TAG_id);

                if (msg.equals("Rate Successfull..")) {

                    return 1;

                } else if (msg.equals(" ")) {
                    return 2;
                } else {
                    return 3;
                }
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }

        } catch (Exception e) {
            return 0;
        }
    }

    public int authUser(Context context,String emailid, String Pass) {
        try {
            StringBuilder result = new StringBuilder();
            String email = emailid;
            String pass = Pass;
            String url = String.format(localurl + "Login/" + email + "/" + pass);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jobj = new JSONObject(result.toString());
                String userid = jobj.getString("userid");
                String useremail = jobj.getString("emailid");
                String Password = jobj.getString("Password");
                String msg = jobj.getString("Msg");

                if (useremail != "null" && Password != "null") {

                    Userdata.setUserid(userid);
                    Userdata.setEmail(useremail);
                    Userdata.setPassword(Password);

                    sharedPreferences =context.getSharedPreferences(PreferencesClass.loginPref, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("logstatus","1");
                    editor.putString("userid",userid);
                    editor.putString("useremail",useremail);
                    editor.putString("password",Password);
                    editor.commit();

                    return 1;
                } else {
                    return 2;
                }
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean getofferlist() {
        try {

            ArrayList<String> offerid, offername, offerprice, offerdescription, offerstartdate, offerlastdate, image,v_vendorid,v_name,v_lat,v_log;
            ArrayList<Double> InformationDistance;

            StringBuilder result = new StringBuilder();

           String url = String.format(localurl + "getnearOfferlist/"+Location_.getLatitude()+"/"+Location_.getLongitude());
           // String url = String.format("http://my-demo.in/Locationbased_Ads_service/Service1.svc/getnearOfferlist/19.2134307/72.841745");

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                offerid = new ArrayList<String>(length);
                offername = new ArrayList<String>(length);
                offerprice = new ArrayList<String>(length);
                offerdescription = new ArrayList<String>(length);
                offerstartdate = new ArrayList<String>(length);
                offerlastdate = new ArrayList<String>(length);
                image = new ArrayList<String>(length);
                v_vendorid=new ArrayList<String>(length);
                v_name=new ArrayList<String>(length);
                v_lat=new ArrayList<String>(length);
                v_log=new ArrayList<String>(length);
                InformationDistance=new ArrayList<Double>(length);



                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String offer_id = job.optString("offerid");
                    String offer_name = job.optString("offername");
                    String offer_price = job.optString("offerprice");
                    String offer_desc = job.optString("offerdescription");
                    String offer_startdate = job.optString("offerstartdate");
                    String offer_lastdate = job.optString("offerlastdate");
                    String offer_img = job.optString("image");

                    String vendor_id=job.optString("v_vendorid");
                    String vname=job.optString("vendor_name");
                    String vlat=job.optString("latitude");
                    String vlog=job.optString("longitude");
                    Double info_dist=job.optDouble("InformationDistance");
                    Double info_dist_km=(info_dist/1000);



                     if (info_dist_km< selectrange.getRange()) {
                         offerid.add(offer_id);
                         offername.add(offer_name);
                         offerprice.add(offer_price);
                         offerdescription.add(offer_desc);
                         offerstartdate.add(offer_startdate);
                         offerlastdate.add(offer_lastdate);
                         image.add(offer_img);
                         v_vendorid.add(vendor_id);
                         v_name.add(vname);
                         v_lat.add(vlat);
                         v_log.add(vlog);
                         InformationDistance.add(info_dist);
                     }


                }

                    Offerlist.setOfferid(offerid);
                    Offerlist.setOffername(offername);
                    Offerlist.setOfferprice(offerprice);
                    Offerlist.setOfferdescription(offerdescription);
                    Offerlist.setOfferstartdate(offerstartdate);
                    Offerlist.setOfferlastdate(offerlastdate);
                    Offerlist.setImage(image);
                    Offerlist.setV_vendorid(v_vendorid);
                    Offerlist.setV_name(v_name);
                    Offerlist.setV_lat(v_lat);
                    Offerlist.setV_log(v_log);
                   Offerlist.setInformation_dist(InformationDistance);


                return true;
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int submitoffer() {
        try {

            final String TAG_id = "Msg";
            StringBuilder result = new StringBuilder();

            HttpClient httpclient = new DefaultHttpClient();
            String url = String.format(localurl + "submitoffer");
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("customer_id", insertofferdetails.getCustomer_id());
            jsonObject.accumulate("offer_id", insertofferdetails.getOffer_id());
            jsonObject.accumulate("offer_name", insertofferdetails.getOffername());
            jsonObject.accumulate("offer_desc", insertofferdetails.getOfferdescription());
            jsonObject.accumulate("vendor_id", insertofferdetails.getVendor_id());

            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jobj = new JSONObject(result.toString());
                String msg = jobj.getString(TAG_id);

                if (msg.equals("Data inserted")) {
                    return 1;
                } else if (msg.equals("Offer already exist")) {
                    return 2;
                } else {
                    return 3;
                }
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
           }

        } catch (Exception e) {
            return 0;
        }
    }

    public boolean getexistofferlist() {
        try {

            ArrayList<String> offerid, offername,offerdescription;

            StringBuilder result = new StringBuilder();

            String url = String.format(localurl + "Existingofferlist/"+Userdata.getUserid());
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                offerid = new ArrayList<String>(length);
                offername = new ArrayList<String>(length);

                offerdescription = new ArrayList<String>(length);


                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String offer_id = job.optString("eofferid");
                    String offer_name = job.optString("eoffername");

                    String offer_desc = job.optString("eofferdescription");


                    offerid.add(offer_id);
                    offername.add(offer_name);

                    offerdescription.add(offer_desc);

                }



                Existingofferdata.setEofferid(offerid);
                Existingofferdata.setEoffername(offername);
                Existingofferdata.setEofferdescription(offerdescription);


                return true;
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getcategory() {
        try {

            ArrayList<String> cat_id,category;

            StringBuilder result = new StringBuilder();

            String url = String.format(localurl + "getcategory");
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                cat_id = new ArrayList<String>(length);
                category = new ArrayList<String>(length);




                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String ca_id = job.optString("cat_id");
                    String cat_name = job.optString("category");




                    cat_id.add(ca_id);
                    category.add(cat_name);



                }


                category_data.setCat_id(cat_id);
                category_data.setCategory_name(category);



                return true;
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean getvendorlist() {
        try {

            ArrayList<String> vendor_id,vname,vcontact,vlocation,vdescription,vlongitude,vlatitude,cat_id,rate;

            StringBuilder result = new StringBuilder();

            String url = String.format(localurl + "getvendorlist/"+ selected_cat.getSingle_catid());
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                vendor_id = new ArrayList<String>(length);
                vname = new ArrayList<String>(length);
                vcontact = new ArrayList<String>(length);
                vlocation = new ArrayList<String>(length);
                vdescription = new ArrayList<String>(length);
                vlongitude = new ArrayList<String>(length);
                vlatitude = new ArrayList<String>(length);
                cat_id = new ArrayList<String>(length);
                rate=new ArrayList<String>(length);





                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String vid_ = job.optString("vendor_id");
                    String vname_ = job.optString("vname");
                    String vcontact_ = job.optString("vcontact");
                    String vlocation_ = job.optString("vlocation");
                    String vdescription_ = job.optString("vdescription");
                    String vlongitude_ = job.optString("vlongitude");
                    String vlatitude_= job.optString("vlatitude");
                    String cat_id_=job.optString("cat_id");
                    String rate_=job.optString("rate");



                    vendor_id.add(vid_);
                    vname.add(vname_);
                    vcontact.add(vcontact_);
                    vlocation.add(vlocation_);
                    vdescription.add(vdescription_);
                    vlongitude.add(vlongitude_);
                    vlatitude.add(vlatitude_);
                    cat_id.add(cat_id_);
                    rate.add(rate_);



                }




                vendorlist_data.setVendor_id(vendor_id);
                vendorlist_data.setVname(vname);
                vendorlist_data.setVcontact(vcontact);
                vendorlist_data.setVlocation(vlocation);
                vendorlist_data.setVdescription(vdescription);
                vendorlist_data.setVlatitude(vlatitude);
                vendorlist_data.setVlongitude(vlatitude);
                vendorlist_data.setCat_id(cat_id);
                vendorlist_data.setRate(rate);




                return true;
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





    public boolean getnotificationdata() {
        try {

            ArrayList<String> offerid, offername, offerprice, offerdescription, offerstartdate, offerlastdate, image,v_vendorid,v_name,v_lat,v_log;

            StringBuilder result = new StringBuilder();

            String url = String.format(localurl + "getnearOfferlist/"+Location_.getLatitude()+"/"+Location_.getLongitude());
            /*  String url = String.format(localurl + "getnearOfferlist/"+19.2134307+"/"+72.841745);*/
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                offerid = new ArrayList<String>(length);
                offername = new ArrayList<String>(length);
                offerprice = new ArrayList<String>(length);
                offerdescription = new ArrayList<String>(length);
                offerstartdate = new ArrayList<String>(length);
                offerlastdate = new ArrayList<String>(length);
                image = new ArrayList<String>(length);
                v_vendorid=new ArrayList<String>(length);
                v_name=new ArrayList<String>(length);
                v_lat=new ArrayList<String>(length);
                v_log=new ArrayList<String>(length);



                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String offer_id = job.optString("offerid");
                    String offer_name = job.optString("offername");
                    String offer_price = job.optString("offerprice");
                    String offer_desc = job.optString("offerdescription");
                    String offer_startdate = job.optString("offerstartdate");
                    String offer_lastdate = job.optString("offerlastdate");
                    String offer_img = job.optString("image");

                    String vendor_id=job.optString("v_vendorid");
                    String vname=job.optString("vendor_name");
                    String vlat=job.optString("latitude");
                    String vlog=job.optString("longitude");



                    offerid.add(offer_id);
                    offername.add(offer_name);
                    offerprice.add(offer_price);
                    offerdescription.add(offer_desc);
                    offerstartdate.add(offer_startdate);
                    offerlastdate.add(offer_lastdate);
                    image.add(offer_img);
                    v_vendorid.add(vendor_id);
                    v_name.add(vname);
                    v_lat.add(vlat);
                    v_log.add(vlog);

                }

                Offerlist.setOfferid(offerid);
                Offerlist.setOffername(offername);
                Offerlist.setOfferprice(offerprice);
                Offerlist.setOfferdescription(offerdescription);
                Offerlist.setOfferstartdate(offerstartdate);
                Offerlist.setOfferlastdate(offerlastdate);
                Offerlist.setImage(image);
                Offerlist.setV_vendorid(v_vendorid);
                Offerlist.setV_name(v_name);
                Offerlist.setV_lat(v_lat);
                Offerlist.setV_log(v_log);

                if (Offerlist.getOffername().size()==0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            } else {

               /* response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());*/
               return  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getofferlistbyname(String name) {
        try {

            ArrayList<String> offerid, offername, offerprice, offerdescription, offerstartdate, offerlastdate, image,v_vendorid,v_name,v_lat,v_log;
            ArrayList<Double> InformationDistance;

            StringBuilder result = new StringBuilder();

            String url = String.format(localurl+"getOfferByName/"+name);
            // String url = String.format("http://my-demo.in/Locationbased_Ads_service/Service1.svc/getnearOfferlist/19.2134307/72.841745");

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

                InputStream in = new BufferedInputStream(response.getEntity().getContent());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
                br.close();
                JSONArray jarrayobj = new JSONArray(result.toString());
                int length = 0;
                if (jarrayobj.length() > 0) {
                    length = jarrayobj.length();
                }

                offerid = new ArrayList<String>(length);
                offername = new ArrayList<String>(length);
                offerprice = new ArrayList<String>(length);
                offerdescription = new ArrayList<String>(length);
                offerstartdate = new ArrayList<String>(length);
                offerlastdate = new ArrayList<String>(length);
                image = new ArrayList<String>(length);
                v_vendorid=new ArrayList<String>(length);
                v_name=new ArrayList<String>(length);
                v_lat=new ArrayList<String>(length);
                v_log=new ArrayList<String>(length);
                InformationDistance=new ArrayList<Double>(length);


                for (int i = 0; i < jarrayobj.length(); i++) {
                    JSONObject job = jarrayobj.getJSONObject(i);
                    String offer_id = job.optString("offerid");
                    String offer_name = job.optString("offername");
                    String offer_price = job.optString("offerprice");
                    String offer_desc = job.optString("offerdescription");
                    String offer_startdate = job.optString("offerstartdate");
                    String offer_lastdate = job.optString("offerlastdate");
                    String offer_img = job.optString("image");
                    String vendor_id=job.optString("v_vendorid");

                        offerid.add(offer_id);
                        offername.add(offer_name);
                        offerprice.add(offer_price);
                        offerdescription.add(offer_desc);
                        offerstartdate.add(offer_startdate);
                        offerlastdate.add(offer_lastdate);
                        image.add(offer_img);
                        v_vendorid.add(vendor_id);

                    }
                Offerlist.setOfferid(offerid);
                Offerlist.setOffername(offername);
                Offerlist.setOfferprice(offerprice);
                Offerlist.setOfferdescription(offerdescription);
                Offerlist.setOfferstartdate(offerstartdate);
                Offerlist.setOfferlastdate(offerlastdate);
                Offerlist.setImage(image);
                Offerlist.setV_vendorid(v_vendorid);
                Offerlist.setV_name(v_name);
                Offerlist.setV_lat(v_lat);
                Offerlist.setV_log(v_log);
                Offerlist.setInformation_dist(InformationDistance);
                return true;
            } else {

                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
