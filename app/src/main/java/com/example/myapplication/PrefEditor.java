package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefEditor{

    Context context;
    SharedPreferences preferences;
    String PREF_FILE_NAME = "User_Data";

    public PrefEditor(Context context){
        this.context = context;
    }

    public void writeData(String key, String value){
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

   public void writeData(String key, long value){
        preferences = context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key,value);
        editor.apply();
   }

    public String getString(String key){
        String str = "";
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        str = preferences.getString(key, "");
        return str;
    }


    public long getLong(String key){
        long val = 0;
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        val = preferences.getLong(key, 0);
        return val;
    }

}
