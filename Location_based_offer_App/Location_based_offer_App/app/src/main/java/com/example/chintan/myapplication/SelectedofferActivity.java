package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Userdata;
import com.example.chintan.myapplication.Data.insertofferdetails;
import com.example.chintan.myapplication.Data.selectedofferdata;
import com.squareup.picasso.Picasso;

public class SelectedofferActivity extends AppCompatActivity {

    Button btnregis,btnmap;
    ImageView imageView;
    TextView txtname,txtsdate,txtldate,txtprice,txtdesc,txtvid;
    ProgressDialog dg;
    int resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectedoffer);

        btnregis=findViewById(R.id.btnregister);
        btnmap=findViewById(R.id.btnmap);
        imageView=findViewById(R.id.offerimage);

        txtname=findViewById(R.id.textoffername);
        txtsdate=findViewById(R.id.textstartdate);
        txtldate=findViewById(R.id.textlastdate);
        /*txtprice=findViewById(R.id.textofferaddress);*/
        txtdesc=findViewById(R.id.textofferdesc);
        txtvid = findViewById(R.id.textvendorid);
        txtvid.setText(selectedofferdata.getSelvid());

        String imagepath= selectedofferdata.getSelimage();

        txtname.setText(selectedofferdata.getSeloffername());

        String sdate=selectedofferdata.getSelofferstartdate();

        String[] sdate1=sdate.split(" ");


        txtsdate.setText(sdate1[0]);

        String ldate=selectedofferdata.getSelofferlastdate();
        String[] ldate1=ldate.split(" ");


        String price10=selectedofferdata.getSelofferprice();
        txtldate.setText(ldate1[0]);
      /*  txtprice.setText("Rs. :"+price10);*/
        txtdesc.setText(selectedofferdata.getSelofferdescription());


        Picasso
                .with(SelectedofferActivity.this)
                .load("http://my-demo.in/Locationbased_Ads_web/Vendor/"+imagepath)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);


        insertofferdetails.setCustomer_id(Userdata.getUserid());
        insertofferdetails.setOffer_id(selectedofferdata.getSelofferid());
        insertofferdetails.setOffername(txtname.getText().toString());
        insertofferdetails.setOfferdescription(txtdesc.getText().toString());
        insertofferdetails.setVendor_id(txtvid.getText().toString());

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submit();

            }
        });
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectedofferActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });



    }

    public void submit()
    {
      final Connection conn=new Connection();
      if (conn.checkNetworkAvailable(SelectedofferActivity.this))
      {
          dg=new ProgressDialog(SelectedofferActivity.this);
          dg.setMessage("Processing ....");
          dg.show();
          Thread tthread = new Thread() {
              @Override
              public void run() {
                  try {
                      resp = conn.submitoffer();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  hd.sendEmptyMessage(0);

              }
          };
          tthread.start();

      }
      else
      {
          Toast.makeText(SelectedofferActivity.this,"Sorry no network access.", Toast.LENGTH_LONG).show();
      }
    }
    public Handler hd = new Handler() {
        public void handleMessage(Message msg) {

            if (dg.isShowing())
                dg.dismiss();

            switch (resp) {
                case 1:
                    Toast.makeText(getApplicationContext(), "Offer Register Successfully", Toast.LENGTH_LONG).show();
                    finish();
                    break;

                case 2:
                    Toast.makeText(getApplicationContext(), "Offer already Registered", Toast.LENGTH_LONG).show();
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
