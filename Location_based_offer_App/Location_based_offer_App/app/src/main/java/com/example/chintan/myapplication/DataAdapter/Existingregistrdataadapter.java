package com.example.chintan.myapplication.DataAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chintan.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Existingregistrdataadapter extends ArrayAdapter<String> {

    public Activity context;

    public ArrayList<String> Offerid;
    public ArrayList<String> Offerdesc;
    public ArrayList<String> Offername;

    public Existingregistrdataadapter(Activity context, ArrayList<String> offerid_, ArrayList<String> offername_, ArrayList<String> offerdesc_)
    {
        super(context,R.layout.listregisteredoffer,offerid_);
        this.context=context;
        this.Offerid=offerid_;
        this.Offerdesc=offername_;
        this.Offername=offerdesc_;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listregisteredoffer, null, true);



        TextView textViewname=(TextView)rowView.findViewById(R.id.txtname);
        TextView textviewdesc=rowView.findViewById(R.id.txtdesc);

        textViewname.setText(Offername.get(position));
        textviewdesc.setText(Offerdesc.get(position));

        return rowView;
    }
}
