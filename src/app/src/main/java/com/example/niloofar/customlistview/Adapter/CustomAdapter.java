package com.example.niloofar.customlistview.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.niloofar.customlistview.R;
import com.example.niloofar.customlistview.Contact;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contact>data;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Contact> data) {

        this.context = context;
        this.data = data;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class viewHolder{

        public TextView txtName;
        public TextView txtMessage;
        public  TextView txtDate;
        public ImageView imgProfile;

        public LinearLayout lnrContainer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;
        viewHolder holder=new viewHolder();
        if(vi==null){
            vi=inflater.inflate(R.layout.contact_item,null);
            holder.txtName=vi.findViewById(R.id.txv_name);
            holder.txtDate=vi.findViewById(R.id.txv_date);
            holder.txtMessage=vi.findViewById(R.id.txv_message);
            holder.imgProfile=vi.findViewById(R.id.iv_profile);
            holder.lnrContainer=vi.findViewById(R.id.contact_lnrContainer);

            vi.setTag(holder);
        }
        else
            holder=(viewHolder)vi.getTag();

        if(data.size()>0){
            Contact tempValue=data.get(position);
            holder.txtName.setText(tempValue.getName());
            holder.txtDate.setText(tempValue.getDate());
            holder.txtMessage.setText(tempValue.getMessage());

            String uri="@drawable/"+tempValue.getImage();
            int imageResource=context.getResources().getIdentifier(uri,null,context.getPackageName());
            holder.imgProfile.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),imageResource,null));

            if (tempValue.isSeen()){

                holder.txtName.setTypeface(null, Typeface.NORMAL);
                holder.txtDate.setTypeface(null,Typeface.NORMAL);
                holder.txtMessage.setTypeface(null,Typeface.NORMAL);
                holder.lnrContainer.setBackgroundColor(Color.parseColor("#efefef"));
            }
            else{
                holder.txtName.setTypeface(null,Typeface.BOLD);
                holder.txtMessage.setTypeface(null,Typeface.BOLD);
                holder.txtDate.setTypeface(null,Typeface.BOLD);
                holder.lnrContainer.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
        return vi;
    }
}
