package com.example.chintan.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Location_;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.selectedofferdata;
import com.example.chintan.myapplication.Data.vendorlist_data;
import com.example.chintan.myapplication.DataAdapter.DataAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class ViewofferlistActivity extends AppCompatActivity
        {

    private GoogleApiClient googleApiClient;
    private Location lastLocation;
    private LocationRequest locationRequest;
    private final int UPDATE_INTERVAL = 1000;
    private final int FASTEST_INTERVAL = 900;
    private final int REQ_PERMISSION = 999;

    ListView offerlist;
    ProgressDialog progressDialog;
    int resp;

    DataAdapter Dadapter;

     public ArrayList<String> offerid,offername,offerprice,offerdescription,offerstartdate,offerlastdate,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewofferlist);

        /*createGoogleApi();*/
        offerlist=findViewById(R.id.listviewoffer);
        offerlist.setTextFilterEnabled(true);


        filladapter();

        offerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedofferdata.setSelofferid(Offerlist.getOfferid().get(position));
                selectedofferdata.setSeloffername(Offerlist.getOffername().get(position));
                selectedofferdata.setSelofferdescription(Offerlist.getOfferdescription().get(position));
                selectedofferdata.setSelofferprice(Offerlist.getOfferprice().get(position));
                selectedofferdata.setSelofferstartdate(Offerlist.getOfferstartdate().get(position));
                selectedofferdata.setSelofferlastdate(Offerlist.getOfferlastdate().get(position));
                selectedofferdata.setSelimage(Offerlist.getImage().get(position));
                selectedofferdata.setSellat(Offerlist.getV_lat().get(position));
                selectedofferdata.setSellong(Offerlist.getV_log().get(position));
                selectedofferdata.setSelvid(Offerlist.getV_vendorid().get(position));
                //Toast.makeText(getApplicationContext(),Offerlist.getV_vendorid().get(position),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ViewofferlistActivity.this,SelectedofferActivity.class);
                startActivity(intent);
            }
        });
    }

    public void filladapter()
    {
        final Connection conn = new Connection();
        if (conn.checkNetworkAvailable(ViewofferlistActivity.this)) {

         /*   if(Location_.getLatitude()!=null)
            {*/
                progressDialog = new ProgressDialog(this);
                progressDialog.show();
                Thread tthread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            if (conn.getofferlist()) {
                                resp = 0;
                            } else {
                                resp = 1;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        nearhd.sendEmptyMessage(0);

                    }
                };
                tthread.start();
          /*  }*/
          /*  else
            {
                if (mySwipeRefreshLayout.isRefreshing()) {
                    mySwipeRefreshLayout.setRefreshing(false);
                }
                Toast.makeText(ViewofferlistActivity.this, "Location not yet Captured !!!" +
                        "refresh page", Toast.LENGTH_SHORT).show();
            }*/

        }
        else {
            Toast.makeText(this, "Sorry no network access.", Toast.LENGTH_LONG).show();
        }
    }

    public Handler nearhd = new Handler() {
        public void handleMessage(Message msg) {

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
                switch (resp) {
                case 0:
                    offerid=Offerlist.getOfferid();
                    offername=Offerlist.getOffername();
                    image=Offerlist.getImage();

                    if(offerid.isEmpty())
                    {
                        Toast.makeText(ViewofferlistActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Dadapter=new DataAdapter(ViewofferlistActivity.this,offerid,offername,image);
                        offerlist.setAdapter(Dadapter);
                    }
                    break;
                case 1:
                    Toast.makeText(ViewofferlistActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };

}
