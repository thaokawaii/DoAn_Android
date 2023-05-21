package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    ListView listView;

    String connectionResult="";
    Connection connect;
    NavigationView navigationView;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         check_internet();
        menu();
    }


    public void menu()
    {
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
    public void check_internet ()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {
            // Internet đang được kết nối
            Toast.makeText(this, "Connected to Internet", Toast.LENGTH_SHORT).show();
        } else {
            // Không có kết nối mạng
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again.")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }


}