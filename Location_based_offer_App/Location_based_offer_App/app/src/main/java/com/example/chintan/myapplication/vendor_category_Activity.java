package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.selectcategory_data;
import com.example.chintan.myapplication.Data.selected_cat;

public class vendor_category_Activity extends AppCompatActivity {

    TextView txtvname,txtcat_name,txtAdd;
    RatingBar ratingbar;
    Button btnsubmit;
    ProgressDialog dg;
    int resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_category_);

        txtvname=findViewById(R.id.txtvname);
        txtcat_name=findViewById(R.id.txtcat);
        txtAdd=findViewById(R.id.txtaddress);
        ratingbar= findViewById(R.id.ratingBar);
        btnsubmit=findViewById(R.id.btnsubmit);


        txtvname.setText(selectcategory_data.getV_name());
        txtcat_name.setText(selected_cat.getSingle_catname());
        txtAdd.setText(selectcategory_data.getV_location());

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating();
                }
        });





    }

    public void  rating()
    {
        int rating=(int)(ratingbar.getRating());



        selectcategory_data.setRate(rating);
      /*  Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();*/

        final Connection conn = new Connection();
        if (Connection.checkNetworkAvailable(vendor_category_Activity.this)) {
            dg = new ProgressDialog(vendor_category_Activity.this);
            dg.setMessage("Processing ....");
            dg.show();

            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        resp = conn.rate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hd.sendEmptyMessage(0);

                }
            };
            tthread.start();
        } else {
            Toast.makeText(vendor_category_Activity.this,"Sorry no network access.", Toast.LENGTH_LONG).show();
        }



    }

    public Handler hd = new Handler() {
        public void handleMessage(Message msg) {

            if (dg.isShowing())
                dg.dismiss();

            switch (resp) {
                case 1:
                    Toast.makeText(getApplicationContext(), "Rating Successfully", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(vendor_category_Activity.this,vendorlistActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    break;

                case 2:
                    Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_LONG).show();
                    break;

                case 3:
                    Toast.makeText(getApplicationContext(), "Try Later", Toast.LENGTH_LONG).show();
                    break;

                case 0:
                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };



}
