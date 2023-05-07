package com.example.datphong.Activity;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.datphong.Adapter.ConnectSQL;


import com.example.datphong.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private DrawerLayout drawerLayout;

    String connectionResult="";
Connection connect;
NavigationView navigationView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Home:
                        Toast.makeText(MainActivity.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        recreate();


                        return true;
                    case R.id.Order:
                        Toast.makeText(MainActivity.this, "Đơn đặt phòng", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,DonDat.class);
                        startActivity(i);
                        return true;
                    case R.id.Logout:
                       Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                        Intent y=new Intent(MainActivity.this,DangNhap.class);
                        startActivity(y);

                        return true;

                }
                return false;
            }
        });
    }

//    public ArrayList<Ban> getArrayList()
//    {
//        ArrayList<Ban> dsb=new ArrayList<>();
//        TextView txv1 =(TextView) findViewById(R.id.ma);
//        TextView txv2 =(TextView) findViewById(R.id.ten);
//        TextView txv3 =(TextView) findViewById(R.id.trangthai);
//        try {
//            ConnectSQL connectionHelper = new ConnectSQL();
//            connect= connectionHelper.conclass();
//            if(connect!=null)
//            {
//                String query = "Select * from BAN";
//                Statement smt= connect.createStatement();
//                ResultSet rs = smt.executeQuery(query);
//
//                while(rs.next())
//                {
//                    Ban b = new Ban(rs.getString("maban").trim(), rs.getString("tenban").trim(), rs.getString("trangthai").trim());
//                    dsb.add(b);
//
//
//
//                }
//            }
//            else
//            {
//                connectionResult="Check Connection";
//            }
//
//        }
//        catch (Exception ex)
//        {
//            Log.e("Error :", ex.getMessage());
//        }
//        return dsb;
//    }
}