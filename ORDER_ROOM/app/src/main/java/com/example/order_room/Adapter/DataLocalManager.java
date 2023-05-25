package com.example.order_room.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;

import com.example.order_room.Model.User;
import com.google.gson.Gson;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL="PREF_FIRST_INSTALL";
    private static final String PREF_NAME_USERS="PREF_NAME_USERS";
    private static final String PRE_OBJECT_USER ="PRE_OBJECT_USER" ;
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;
    public static void init(Context context)
    {
        instance=new DataLocalManager();
        instance.mySharedPreferences=new MySharedPreferences(context);
    }
    public static DataLocalManager getInstance()
    {
        if(instance==null)
        {
            instance=new DataLocalManager();

        }
        return instance;
    }
public  static void setPrefFirstInstalled(boolean isFirst)
{
    DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FIRST_INSTALL,isFirst);
}
public static boolean getFirstInstalled()
{
    return DataLocalManager.getInstance().mySharedPreferences.getBooleanValues((PREF_FIRST_INSTALL));

}
public static void setUser(User user)
{
    Gson gson=new Gson();
    String strJsonUser=gson.toJson(user);
    DataLocalManager.getInstance().mySharedPreferences.putStringValue(PRE_OBJECT_USER,strJsonUser);
}
    public static void remove(User user)
    {
        Gson gson=new Gson();
        String strJsonUser=gson.toJson(user);
        DataLocalManager.getInstance().mySharedPreferences.remove(strJsonUser);
    }

   public static User getUser()
   {
       String strJsonUser=DataLocalManager.getInstance().mySharedPreferences.getStringValue(PRE_OBJECT_USER);
       Gson gson=new Gson();
       User user=gson.fromJson(strJsonUser,User.class);
       return user;
   }


}
