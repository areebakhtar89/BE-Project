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
import com.example.chintan.myapplication.Data.category_data;
import com.example.chintan.myapplication.Data.selectcategory_data;
import com.example.chintan.myapplication.Data.selected_cat;
import com.example.chintan.myapplication.Data.vendorlist_data;
import com.example.chintan.myapplication.DataAdapter.DataAdapter;
import com.example.chintan.myapplication.DataAdapter.adaptercategory;

import java.util.ArrayList;

public class view_category extends AppCompatActivity {
    ListView offerlist;
    ProgressDialog progressDialog;
    int resp;
    public ArrayList<String> catid,catname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_category);
        filladapter_cat();
        offerlist=findViewById(R.id.listviewcat);

        offerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selected_cat.setSingle_catid(category_data.getCat_id().get(position));
                selected_cat.setSingle_catname(category_data.getCategory_name().get(position));
                Intent intent=new Intent(view_category.this,vendorlistActivity.class);
                startActivity(intent);



            }
        });


    }
    public void filladapter_cat()
    {
        final Connection conn = new Connection();
        if (conn.checkNetworkAvailable(view_category.this)) {

         /*   if(Location_.getLatitude()!=null)
            {*/
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        if (conn.getcategory()) {
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
                    catid= category_data.getCat_id();
                    catname=category_data.getCategory_name();

                 /*   if(offerid.isEmpty())
                    {
                        Toast.makeText(ViewofferlistActivity.this, "Data not found", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {*/
                    adaptercategory catdapter=new adaptercategory(view_category.this,catid,catname);
                    offerlist.setAdapter(catdapter);

                    /* }*/

                    break;
                case 1:
                    Toast.makeText(view_category.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };

}
