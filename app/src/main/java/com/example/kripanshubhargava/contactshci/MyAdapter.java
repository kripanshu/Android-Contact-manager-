package com.example.kripanshubhargava.contactshci;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.kripanshubhargava.contactshci.R.id;
import static com.example.kripanshubhargava.contactshci.R.layout;


/**
 * Created by kripanshubhargava on 3/23/17.
 */

class MyAdapter extends BaseAdapter {

    Context context;

    ArrayList name;
    ArrayList contact;

    MyAdapter(Context c,ArrayList name1, ArrayList contact1)
    {
       // super(c,id.Name ,id.Contact);

        this.context=c;
        this.name=name1;
        this.contact=contact1;


    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(layout.list_row,parent,false);
        TextView myTitle = (TextView) row.findViewById(id.Name);
        TextView myDesc = (TextView) row.findViewById(id.Contact);
        name.add(position,myTitle);
        contact.add(position,myDesc);
        return row;
    }

}
