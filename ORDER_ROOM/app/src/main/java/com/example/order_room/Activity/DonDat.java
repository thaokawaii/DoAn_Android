package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;

public class DonDat extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_dat);

      menu();
    }
    private void menu()
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
                        Toast.makeText(DonDat.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(DonDat.this,TrangChu.class);
                        startActivity(i);


                        return true;
                    case R.id.Order:
                        Toast.makeText(DonDat.this, "Đơn đặt phòng", Toast.LENGTH_SHORT).show();
                        recreate();

                        return true;
                    case R.id.Logout:
                        Toast.makeText(DonDat.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                        Intent y=new Intent(DonDat.this,DangNhap.class);
                        startActivity(y);

                        return true;

                }
                return false;
            }
        });
    }
}