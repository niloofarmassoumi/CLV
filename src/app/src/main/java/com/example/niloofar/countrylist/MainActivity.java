package com.example.niloofar.countrylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<country> dataSet=new ArrayList<>();
    ListView listObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      listObj =findViewById(R.id.lv_country);

        country iran=new country("Iran",5455555);
        country Germany=new country("Geramany",845415);
        country England=new country("England",5845648);
        country Italy=new country("Italy",8454522);
        country berezilia=new country("Berezilia",454556465);
        country orogue=new country("orogue",484578456);



        dataSet.add(iran);
        dataSet.add(Germany);
        dataSet.add(England);
        dataSet.add(Italy);
        dataSet.add(berezilia);
        dataSet.add(orogue);

        CountryListAdaptor listAdaptor=new CountryListAdaptor(getApplicationContext(),R.layout.country_list_template,dataSet);

        listObj.setAdapter(listAdaptor);



    }

    public void addbtn(View view){

        EditText nameObj=findViewById(R.id.txt_name);
        EditText popObj=findViewById(R.id.txt_pop);

        String name=nameObj.getText().toString();
        long pop= Long.parseLong(popObj.getText().toString());

        country tmp=new country(name,pop);
        dataSet.add(tmp);

        CountryListAdaptor listAdaptor=new CountryListAdaptor(getApplicationContext(),R.layout.country_list_template,dataSet);
        listObj.setAdapter(listAdaptor);
    }
}
