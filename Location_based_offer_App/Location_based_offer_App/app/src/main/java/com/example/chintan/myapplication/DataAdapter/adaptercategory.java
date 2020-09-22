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

public class adaptercategory extends ArrayAdapter<String> {
    public Activity context;

    public ArrayList<String> catid;
    public ArrayList<String> catname;


    public adaptercategory(Activity context,ArrayList<String> Iid_,ArrayList<String> catname_)
    {
        super(context,R.layout.newofferdetails,Iid_);
        this.context=context;
        this.catid=Iid_;
        this.catname=catname_;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.vendoradapter, null, true);


        TextView textvendor=(TextView)rowView.findViewById(R.id.txtcatname);


        textvendor.setText(catname.get(position));


        return rowView;
    }

}
