package com.example.assignment_1.Controllers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("MyReference", Context.MODE_PRIVATE );
    }

    public void saveProfileName(String key,String value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }


    public void saveProfileInteger(String key,int value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public String getStringByKey(String key)
    {
        return sharedPreferences.getString(key,"");
    }

    public int getIntByKey(String key)
    {
        return sharedPreferences.getInt(key,0);
    }



    public void clear() {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void modify(String key) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }
}
