package com.example.chintan.myapplication.DataAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chintan.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter_vendor extends ArrayAdapter<String> {
    public Activity context;

    public ArrayList<String> vendor_id;
    public ArrayList<String> vname;
    public ArrayList<String> rate;


    public adapter_vendor(Activity context,ArrayList<String> Iid_,ArrayList<String> vname_,ArrayList<String> rate_)
    {
        super(context,R.layout.newofferdetails,Iid_);
        this.context=context;
        this.vendor_id=Iid_;
        this.vname=vname_;
        this.rate=rate_;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.vendornamelist, null, true);



        TextView textvname=(TextView)rowView.findViewById(R.id.txtvname);
        TextView textoffname=(TextView)rowView.findViewById(R.id.txtoffname);

        textvname.setText(vname.get(position));
        textoffname.setText(rate.get(position));

        return rowView;
    }
}
