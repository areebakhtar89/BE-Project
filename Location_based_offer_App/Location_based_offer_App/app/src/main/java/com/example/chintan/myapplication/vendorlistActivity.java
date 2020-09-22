package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.selectcategory_data;
import com.example.chintan.myapplication.Data.vendorlist_data;
import com.example.chintan.myapplication.DataAdapter.DataAdapter;
import com.example.chintan.myapplication.DataAdapter.adapter_vendor;

import java.util.ArrayList;

public class vendorlistActivity extends AppCompatActivity {

    ListView offerlist;
    ProgressDialog progressDialog;
    int resp;
    public ArrayList<String> vendor_id,vendorname,rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendorlist);

        filladapter();
        offerlist=findViewById(R.id.listviewvendorlist);
        offerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   selectcategory_data.setVendor_id(vendorlist_data.getVendor_id().get(position));
                   selectcategory_data.setV_name(vendorlist_data.getVname().get(position));
                   selectcategory_data.setV_contact(vendorlist_data.getVcontact().get(position));
                   selectcategory_data.setV_location(vendorlist_data.getVlocation().get(position));
                   selectcategory_data.setV_description(vendorlist_data.getVdescription().get(position));
                   selectcategory_data.setV_lat(vendorlist_data.getVlatitude().get(position));
                   selectcategory_data.setV_lon(vendorlist_data.getVlongitude().get(position));
                   selectcategory_data.setCat_id(vendorlist_data.getCat_id().get(position));
                   selectcategory_data.setOldrate(vendorlist_data.getRate().get(position));

                Intent intent=new Intent(vendorlistActivity.this,vendor_category_Activity.class);
                startActivity(intent);

            }
        });


    }

    public void filladapter()
    {
        final Connection conn = new Connection();
        if (conn.checkNetworkAvailable(vendorlistActivity.this)) {

         /*   if(Location_.getLatitude()!=null)
            {*/
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        if (conn.getvendorlist()) {
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
                    vendor_id=vendorlist_data.getVendor_id();
                    rate=vendorlist_data.getRate();
                    vendorname=vendorlist_data.getVname();

                    if(vendor_id.isEmpty())
                    {
                        Toast.makeText(vendorlistActivity.this, "Data not found", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                    adapter_vendor Dadapter=new adapter_vendor(vendorlistActivity.this,vendor_id,vendorname,rate);
                    offerlist.setAdapter(Dadapter);

                     }

                    break;
                case 1:
                    Toast.makeText(vendorlistActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };

}
