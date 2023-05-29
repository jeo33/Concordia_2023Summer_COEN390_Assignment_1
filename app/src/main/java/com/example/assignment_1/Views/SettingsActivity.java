package com.example.assignment_1.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_1.Models.Setting_activity_model;
import com.example.assignment_1.R;
import com.example.assignment_1.Controllers.SharedPreferenceHelper;

public class SettingsActivity extends AppCompatActivity {
    SharedPreferenceHelper SPH;
    Setting_activity_model display=new Setting_activity_model();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        EditText item1=findViewById(R.id.Counter_A_Name_input);
        EditText item2=findViewById(R.id.Counter_B_Name_input);
        EditText item3=findViewById(R.id.Counter_C_Name_input);
        EditText item4=findViewById(R.id.Maximum_Count_input);
        EditText[] dataArray = {item1,item2,item3,item4};


        SPH=new SharedPreferenceHelper(SettingsActivity.this);
        Button save_button=findViewById(R.id.Save_Button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(item1.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Counter1 name is empty", Toast.LENGTH_SHORT).show();
                } else if (item2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Counter2 name is empty", Toast.LENGTH_SHORT).show();
                } else if (item3.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Counter3 name is empty", Toast.LENGTH_SHORT).show();
                } else if (item4.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Max count is empty", Toast.LENGTH_SHORT).show();
                }  else if (Integer.parseInt(item4.getText().toString())<5 ||Integer.parseInt(item4.getText().toString())>200) {
                    Toast.makeText(getApplicationContext(), "Max count should be [5,200]", Toast.LENGTH_SHORT).show();
                } else
                {
                    int cc=1;
                    for (EditText s:dataArray) {
                        if(cc<=3)
                        {
                            SPH.saveProfileName("item"+ cc,s.getText().toString());
                            display.SetLabels(cc-1,s.getText().toString());
                            Log.v("this is the text for", s.getText().toString());
                            Log.v("this is the text for", String.valueOf(cc-1));
                            Log.v("this is the text for",s.getText().toString());
                            cc++;
                        }
                        else
                        {
                            SPH.saveProfileInteger("item"+ cc,Integer.parseInt(s.getText().toString()));
                            SPH.saveProfileInteger("count",0);
                        }
                    }
                    SPH.saveProfileInteger("count",0);
                    SPH.saveProfileName("log",null);
                    save_button.setVisibility(View.INVISIBLE);
                    for (EditText s:dataArray) {
                        s.setEnabled(false);
                        s.setFocusable(false);
                    }
                }
            }
        });



        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("edit"))
        {
            save_button.setVisibility(View.VISIBLE);
            for (EditText s:dataArray) {
                s.setEnabled(true);
                s.setFocusable(true);
                s.setFocusableInTouchMode(true);
                s.requestFocus();
            }
        } else if (intent != null && intent.hasExtra("display"))
        {
            display.SetLabels(0,SPH.getStringByKey("item1"));
            display.SetLabels(1,SPH.getStringByKey("item2"));
            display.SetLabels(2,SPH.getStringByKey("item3"));
            display.setSize(SPH.getIntByKey("item4"));
            display.SetLabels(3,String.valueOf(SPH.getIntByKey("item4")));
            save_button.setVisibility(View.INVISIBLE);
            int c=0;
            for (EditText s:dataArray) {
                s.setEnabled(false);
                s.setFocusable(false);
                s.setFocusableInTouchMode(false);
                s.requestFocus();
                s.setText(display.GetLabels(c));
                c++;
            }
        }

    }




    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.setting_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {

        Button save_button=findViewById(R.id.Save_Button);
        int item_constant=item.getItemId();
        if(item_constant==R.id.add_item)
        {
            save_button.setVisibility(View.VISIBLE);
            EditText item1=findViewById(R.id.Counter_A_Name_input);
            EditText item2=findViewById(R.id.Counter_B_Name_input);
            EditText item3=findViewById(R.id.Counter_C_Name_input);
            EditText maxCount=findViewById(R.id.Maximum_Count_input);
            EditText[] dataArray = {item1,item2,item3,maxCount};
            for (EditText s:dataArray) {
                s.setEnabled(true);
                s.setFocusable(true);
                s.setFocusableInTouchMode(true);
                s.requestFocus();
                s.setText("");
            }

        }
        else if (item_constant==android.R.id.home)
        {
            String newText = "T"; // Replace with the desired new text
            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            intent.putExtra("new", newText);
            startActivity(intent);
        }
        return true;

    }



}

