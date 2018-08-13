package com.example.niloofar.countrylist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.List;

public class CountryListAdaptor extends ArrayAdapter<country> {

Context mc;
int mr;
    public CountryListAdaptor(@NonNull Context context, int resource, @NonNull List<country> objects) {
        super(context, resource, objects);

        mc=context;
        mr=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View convert= LayoutInflater.from(mc).inflate(mr,parent,false);

        TextView nameObj= convert.findViewById(R.id.txv_name);
        TextView popObj=convert.findViewById(R.id.txv_pop);

        nameObj.setText(getItem(position).getName());
        popObj.setText(String.valueOf(getItem(position).getPopulation()));

        return convert;
    }
}
