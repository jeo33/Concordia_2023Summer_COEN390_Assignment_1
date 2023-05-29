package com.example.assignment_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assignment_1.Models.Data_activity_model;
import com.example.assignment_1.Models.Setting_activity_model;
import com.example.assignment_1.R;
import com.example.assignment_1.Controllers.SharedPreferenceHelper;

public class DataActivity extends AppCompatActivity {
    SharedPreferenceHelper SPH;
    Data_activity_model data;
    TextView v1,v2,v3,v4,t1,t2,t3;
    String x1,x2,x3;
    int toggleFlag=0;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        SPH=new SharedPreferenceHelper(DataActivity.this);
        data=new Data_activity_model(SPH.getIntByKey("count"),SPH.getStringByKey("log"),SPH.getStringByKey("item1"),SPH.getStringByKey("item2"),SPH.getStringByKey("item3"));

        Log.v("logout","test1");
        x1="Counter 1";
        x2="Counter 2";
        x3="Counter 3";
        t1=findViewById(R.id.tittle1);
        t2=findViewById(R.id.tittle2);
        t3=findViewById(R.id.tittle3);
        v1=findViewById(R.id.item1display);
        v2=findViewById(R.id.item2display);
        v3=findViewById(R.id.item3display);
        v4=findViewById(R.id.TotalCount);
        Log.v("logout",data.getLog());
        Log.v("logout",data.getLog());
        Log.v("logout",String.valueOf(data.getcount(1)));
        Log.v("logout",String.valueOf(data.getcount(2)));
        Log.v("logout",String.valueOf(data.getcount(3)));
        listView=findViewById(R.id.listView);

        Log.v("logout","test2");
        String s1=": "+data.getcount(1)+" events";
        String s2=": "+data.getcount(2)+" events";
        String s3=": "+data.getcount(3)+" events";
        String s4="Total events:   "+data.getCount();

        Log.v("logout","test3");
        t1.setText(data.GetLabels(0));
        t2.setText(data.GetLabels(1));
        t3.setText(data.GetLabels(2));
        v1.setText(s1);
        v2.setText(s2);
        v3.setText(s3);
        v4.setText(s4);

        Log.v("logout","test2");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data.printListViewDisplay_number());
        listView.setAdapter(adapter);
        toggleFlag=1;
    }





    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.data_activity_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {

        int item_constant=item.getItemId();
        if(item_constant==R.id.Toggle_event_names)
        {
            String s1=": "+data.getcount(1)+" events";
            String s2=": "+data.getcount(2)+" events";
            String s3=": "+data.getcount(3)+" events";
            String s4="Total events: "+data.getCount();
            v1.setText(s1);
            v2.setText(s2);
            v3.setText(s3);
            v4.setText(s4);

            if(toggleFlag==0)
            {

                t1.setText(data.GetLabels(0));
                t2.setText(data.GetLabels(1));
                t3.setText(data.GetLabels(2));

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data.printListViewDisplay_number());
                listView.setAdapter(adapter);
                toggleFlag=1;
            }
            else {

                t1.setText(x1);
                t2.setText(x2);
                t3.setText(x3);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data.printListViewDisplay_name());
                listView.setAdapter(adapter);
                toggleFlag=0;
            }

        }
        else if (item_constant==android.R.id.home)
        {
            String newText = "T"; // Replace with the desired new text
            Intent intent = new Intent(DataActivity.this, MainActivity.class);
            intent.putExtra("new", newText);
            startActivity(intent);
        }


        return true;

    }


}

