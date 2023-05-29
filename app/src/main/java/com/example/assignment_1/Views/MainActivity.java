package com.example.assignment_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment_1.Models.Setting_activity_model;
import com.example.assignment_1.R;
import com.example.assignment_1.Controllers.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int count;
    String log;
    TextView tv1,tv2,tv3,tv4;
    Button toSetting;
    Button ShowMyCount,item1Button,item2Button,item3Button;
    Intent intentToSetting,intentToData;
    Setting_activity_model display=new Setting_activity_model();

    protected SharedPreferenceHelper SPH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SPH = new SharedPreferenceHelper(MainActivity.this);
        intentToSetting=new Intent(this,SettingsActivity.class);
        intentToData=new Intent(this,DataActivity.class);
        tv1=findViewById(R.id.Event_A_Button);
        tv2=findViewById(R.id.Event_B_Button);
        tv3=findViewById(R.id.Event_C_Button);
        tv4=findViewById(R.id.Total_Count);
        toSetting=(Button) findViewById(R.id.Setting_Button);
        ShowMyCount=(Button) findViewById(R.id.Show_My_Count);
        item1Button=(Button) tv1;
        item2Button=(Button) tv2;
        item3Button=(Button) tv3;

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("new"))
        {
            Log.v("back from setting","Received");
            display.SetLabels(0,SPH.getStringByKey("item1"));

            Log.v("back from setting","1done");
            display.SetLabels(1,SPH.getStringByKey("item2"));

            Log.v("back from setting","2done");
            display.SetLabels(2,SPH.getStringByKey("item3"));

            Log.v("back from setting","3done");
            display.setSize(SPH.getIntByKey("item4"));

            Log.v("back from setting","4halfdone");
            display.SetLabels(3,String.valueOf(SPH.getIntByKey("item4")));

            Log.v("back from setting","4done");
            Log.v("new","new key is T");
            SPH.modify("new");
            SPH.saveProfileName("new","F");

            Log.v("back from setting","done");
        }

        else if (intent != null && intent.hasExtra("fromlog")) {
            Log.v("back from log","Received");
            display.SetLabels(0,SPH.getStringByKey("item1"));
            display.SetLabels(1,SPH.getStringByKey("item2"));
            display.SetLabels(2,SPH.getStringByKey("item3"));
            display.setSize(SPH.getIntByKey("item4"));
            display.SetLabels(3,String.valueOf(SPH.getIntByKey("item4")));
            display.setCount(SPH.getIntByKey("count"));
            count=display.getCount();
            Log.v("new","new key is T");
        }

        count= SPH.getIntByKey("count");
        log=SPH.getStringByKey("log");
        Log.v("count",String.valueOf(count));


        tv1.setText(display.GetLabels(0));
        tv2.setText(display.GetLabels(1));
        tv3.setText(display.GetLabels(2));
        if(count==0)
        {
            tv4.setText(display.GetLabels(3));
        }
        else
        {
            tv4.setText("Total Count"+count);
        }

        Log.v("show display",display.GetLabels(0));
        Log.v("show display",display.GetLabels(1));
        Log.v("show display",display.GetLabels(2));
        Log.v("show display",display.GetLabels(3));
        if(tv1.getText().equals("Event A"))
        {
            intentToSetting.putExtra("edit", "edit");
            startActivity(intentToSetting);
        }

        toSetting.setOnClickListener(this);
        item1Button.setOnClickListener(this);
        item2Button.setOnClickListener(this);
        item3Button.setOnClickListener(this);
        ShowMyCount.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
       if(view.getId()==R.id.Setting_Button) {
           intentToSetting.putExtra("display", "display");
           startActivity(intentToSetting);
       }
       else if (view.getId()==R.id.Show_My_Count) {
           intentToData.putExtra("log", "log");
           startActivity(intentToData);

       }
       else if (view.getId()==R.id.Event_A_Button) {
           if(count<display.getSize())
           {
               count++;
               log=log+'1';
               SPH.saveProfileName("log",log);
               SPH.saveProfileInteger("count",count);

           }

       }else if (view.getId()==R.id.Event_B_Button) {
           if(count<display.getSize())
           {
               count++;
               log=log+'2';
               SPH.saveProfileName("log",log);
               SPH.saveProfileInteger("count",count);
           }

       }else if (view.getId()==R.id.Event_C_Button) {
           if(count<display.getSize())
           {
               count++;
               log=log+'3';
               SPH.saveProfileName("log",log);
               SPH.saveProfileInteger("count",count);
           }



       }
        tv4.setText("Total Count "+count);


    }
}


