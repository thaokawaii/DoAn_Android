package com.example.datphong.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.datphong.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class DonDat extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_dat);

//        ImageView imageView=findViewById(R.id.anh);
//        String url="https://scontent.fsgn2-6.fna.fbcdn.net/v/t39.30808-6/319507976_676850980683883_2487766031917893713_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=SqXpq94AkWgAX9DiKdw&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfA-s60ZR5WUG487Bn31v9L90XjXetCUrJeoPGTFmVGLlw&oe=6457F520";
//        Picasso.with(this).load(url).into(imageView);

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
                        Intent i=new Intent(DonDat.this,MainActivity.class);
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
