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

public class DataAdapter extends ArrayAdapter<String> {
    public Activity context;

    public ArrayList<String> Offerid;
    public ArrayList<String> Offerimagepath;
    public ArrayList<String> Offername;

    public DataAdapter(Activity context,ArrayList<String> Iid_,ArrayList<String> Iname_,ArrayList<String> Ipath_)
    {
        super(context,R.layout.newofferdetails,Iid_);
        this.context=context;
        this.Offerid=Iid_;
        this.Offerimagepath=Ipath_;
        this.Offername=Iname_;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.newofferdetails, null, true);


        ImageView imageView=(ImageView)rowView.findViewById(R.id.image);
        TextView textViewname=(TextView)rowView.findViewById(R.id.txtname);

        textViewname.setText(Offername.get(position));

        Picasso.with(context)
                .load("http://my-demo.in/Locationbased_Ads_web/Vendor/"+Offerimagepath.get(position))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .resize(300,100)
                .into(imageView);
        //end code for picasso
        return rowView;
    }


}
