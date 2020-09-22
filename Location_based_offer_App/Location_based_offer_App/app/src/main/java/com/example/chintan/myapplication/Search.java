package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.selectedofferdata;
import com.example.chintan.myapplication.DataAdapter.DataAdapter;

import java.util.ArrayList;

public class Search extends AppCompatActivity {


    ListView listView;
    ProgressDialog progressDialog;
    int resp;
    public ArrayList<String> offername = new ArrayList<>();
    Button btnSearch;
    EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.listViewName);
        etSearch = findViewById(R.id.editTextSearch);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etSearch.getText().toString().trim();
                if (name.equals(""))
                    Toast.makeText(getApplicationContext(),"Please provide name",Toast.LENGTH_LONG).show();
                else
                    filladapter(name);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedofferdata.setSelofferid(Offerlist.getOfferid().get(position));
                selectedofferdata.setSeloffername(Offerlist.getOffername().get(position));
                selectedofferdata.setSelofferdescription(Offerlist.getOfferdescription().get(position));
                selectedofferdata.setSelofferprice(Offerlist.getOfferprice().get(position));
                selectedofferdata.setSelofferstartdate(Offerlist.getOfferstartdate().get(position));
                selectedofferdata.setSelofferlastdate(Offerlist.getOfferlastdate().get(position));
                selectedofferdata.setSelimage(Offerlist.getImage().get(position));
                selectedofferdata.setSelvid(Offerlist.getV_vendorid().get(position));
                Toast.makeText(getApplicationContext(),Offerlist.getV_vendorid().get(position),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Search.this,SelectedofferActivity.class);
                startActivity(intent);
            }
        });
    }

    public void filladapter(final String name)
    {
        final Connection conn = new Connection();
        if (conn.checkNetworkAvailable(Search.this)) {

         /*   if(Location_.getLatitude()!=null)
            {*/
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        if (conn.getofferlistbyname(name)) {
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

                    offername=Offerlist.getOffername();
                    if(offername.isEmpty())
                    {
                        Toast.makeText(Search.this, "Data not found", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Search.this,android.R.layout.simple_list_item_1,offername);
                        listView.setAdapter(adapter);
                    }
                    break;
                case 1:
                    Toast.makeText(Search.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };
}
