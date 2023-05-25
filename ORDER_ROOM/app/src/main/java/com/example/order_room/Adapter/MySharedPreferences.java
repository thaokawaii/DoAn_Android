package com.example.order_room.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.order_room.Model.User;

import java.util.HashSet;
import java.util.Set;

public class MySharedPreferences {
    private static final String MY_SHARED_FREFERENCES="MY_SHARES_FRERENCES";
    private Context mcontext;
    public MySharedPreferences(Context context)
    {
        this.mcontext=context;

    }
    public void putBooleanValue(String key,boolean values)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(key,values);
        editor.apply();
    }
    public boolean getBooleanValues(String key)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }
    public void putStringValue(String key,String value)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public String getStringValue(String key)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
    public void getStringSetValue(String key, Set<String> values)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putStringSet(key, values);
        editor.apply();
    }
    public Set<String> getStringSetValue(String key)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        Set<String> valueDefault=new HashSet<>();
        return sharedPreferences.getStringSet(key,valueDefault);
    }
    public void remove(String key)
    {
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(MY_SHARED_FREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
