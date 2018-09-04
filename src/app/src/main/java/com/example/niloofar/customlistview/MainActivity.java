package com.example.niloofar.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.niloofar.customlistview.Adapter.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;
    ArrayList<Contact> Contacts =new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setlistDta();

        listView = findViewById(R.id.ListView);
        adapter = new CustomAdapter(this, Contacts);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text="Item("+position+")Is"+ Contacts.get(position).getName();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();

                Contacts.get(position).setSeen(true);
                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();

            }
        });

    }
    void setlistDta(){

       // Contacts.add(new Contact("niloofar","","salam","5shanb",false));
        Contacts.add(new Contact("Bashir", "img1", "Salam", "12:30 PM", false));
        Contacts.add(new Contact("Mojtaba", "img2", "Salam Khubi? Mikhastam Barna...", "6:15 PM", false));
        Contacts.add(new Contact("Amir", "img3", "ghorbanat kari nakardam", "Yesterday", true));
        Contacts.add(new Contact("Mostafa", "img4", "ye sar ta pish ma ham bia ;)", "Mon", true));
        Contacts.add(new Contact("Saeed", "img5", "bia inja man sherkatam", "Mon", true));
        Contacts.add(new Contact("Ali", "img6", "salam 10 min dg mitunam j bedam", "Sat", true));
        Contacts.add(new Contact("Ehsan", "img7", "salam adres site chie?", "Sep 1, 16", true));
        Contacts.add(new Contact("Mohammad", "img8", "I'm bussy, I'll Call Back You Later", "Aug 30, 16", true));
        Contacts.add(new Contact("Iman", "img9", "www.wiadevelopers.com", "Jul 6, 16", true));


    }
}
