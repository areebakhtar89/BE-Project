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
import com.example.chintan.myapplication.Data.Existingofferdata;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.Selectedexistingofferdata;
import com.example.chintan.myapplication.DataAdapter.DataAdapter;
import com.example.chintan.myapplication.DataAdapter.Existingregistrdataadapter;

import java.util.ArrayList;

public class ViewExistingRegistrationActivity extends AppCompatActivity {

    ListView  listexistingoffer;
    ProgressDialog progressDialog;
    int resp;
    public ArrayList<String> offerid_,offername_,offerdesc_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_existing_registration);

        listexistingoffer=findViewById(R.id.listviewexistingoffer);
        bindadapter();

       /* listexistingoffer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Selectedexistingofferdata.setSel_eofferid(Existingofferdata.getEofferid().get(position));
               Selectedexistingofferdata.setSel_eoffername(Existingofferdata.getEoffername().get(position));
               Selectedexistingofferdata.setSel_eofferdescription(Existingofferdata.getEofferdescription().get(position));

                Intent intent=new Intent(ViewExistingRegistrationActivity.this,SelectedExistingofferActivity.class);
                startActivity(intent);
            }
        });*/


    }

    public void bindadapter()
    {
        final Connection conn = new Connection();
        if (conn.checkNetworkAvailable(ViewExistingRegistrationActivity.this)) {

            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        if (conn.getexistofferlist()) {
                            resp = 0;
                        } else {
                            resp = 1;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hd.sendEmptyMessage(0);

                }
            };
            tthread.start();

        }
        else {

            Toast.makeText(this, "Sorry no network access.", Toast.LENGTH_LONG).show();

        }
    }
    public Handler hd = new Handler() {
        public void handleMessage(Message msg) {

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            switch (resp) {
                case 0:
                    offerid_=Existingofferdata.getEofferid();
                    offername_=Existingofferdata.getEoffername();
                    offerdesc_=Existingofferdata.getEofferdescription();


                    if (offerid_.isEmpty()) {
                        Toast.makeText(ViewExistingRegistrationActivity.this, "Data not found", Toast.LENGTH_LONG).show();
                    } else {
                    }

                    Existingregistrdataadapter Dadapter=new Existingregistrdataadapter(ViewExistingRegistrationActivity.this,offerid_,offername_,offerdesc_);
                    listexistingoffer.setAdapter(Dadapter);


                    // }
                    break;
                case 1:
                    Toast.makeText(ViewExistingRegistrationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };
}
