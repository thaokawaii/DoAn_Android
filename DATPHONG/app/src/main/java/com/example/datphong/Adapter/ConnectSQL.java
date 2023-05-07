package com.example.datphong.Adapter;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectSQL {
    Connection connection;
    String ip,port,db,un,pass;

    @SuppressLint("NewApi")
    public Connection conclass(){
        ip="DESKTOP-HIS1CSO";
        port="1433";
        db="QL_QuanCaPhe";
        un="sa";
        pass="123456";
        StrictMode.ThreadPolicy tpolicy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tpolicy);
        Connection con =null;
        String ConnectionURL=null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            ConnectionURL= "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databaseName="+ db+ ";user="+un+";password="+pass+";";
            con= DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex)
        {
            Log.e("loi : ", ex.getMessage());
        }
        return con;
    }



}
