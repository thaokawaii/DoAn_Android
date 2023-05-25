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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Adapter.KhachSanAdapter;
import com.example.order_room.Adapter.LoaiPhongAdapter;
import com.example.order_room.Model.KHACHSAN;

import com.example.order_room.Model.LOAIPHONG;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TrangChu extends AppCompatActivity {
    private DrawerLayout drawerLayout;



    ListView listView;

    NavigationView navigationView;
    List<KHACHSAN> list=new ArrayList<>();
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);



        listView = findViewById(R.id.list_khachsan);
        check_internet();
        menu();
        KhachSanAdapter productAdapter = new KhachSanAdapter( list,this);
        databaseReference = FirebaseDatabase.getInstance().getReference("KHACHSAN");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                   KHACHSAN item = dataSnapshot.getValue(KHACHSAN.class);
                    list.add(item);

                    load();
                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       KHACHSAN ks= (KHACHSAN) productAdapter.getItem(position);
                       Intent intent=new Intent(TrangChu.this,Loai.class);
                        String productCode = ks.getSDT();
                        intent.putExtra("Ma", productCode);
                        setResult(RESULT_OK, intent);
                        Log.e("SDT ks",productCode);
                        startActivity(intent);

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
    private void load() {



        KhachSanAdapter khachSanAdapter = new KhachSanAdapter(list,this);

        listView = findViewById(R.id.list_khachsan);
        listView.setAdapter(khachSanAdapter);

    }
    private void loadKS()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("KHACHSAN");

        // Lấy dữ liệu từ Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    KHACHSAN item = dataSnapshot.getValue(KHACHSAN.class);
                    list.add(item);
                    Log.e("T",item.toString());
                    load();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
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
                        Toast.makeText(TrangChu.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        recreate();


                        return true;
                    case R.id.Order:
                        Toast.makeText(TrangChu.this, "Đơn đặt phòng", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(TrangChu.this,DonDat.class);
                        startActivity(i);
                        return true;
                    case R.id.Logout:
                        DataLocalManager.init(getApplicationContext());
                        User user= DataLocalManager.getUser();
                        DataLocalManager.remove(user);
                        Toast.makeText(TrangChu.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                        Intent y=new Intent(TrangChu.this,DangNhap.class);
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
//            // Internet đang được kết nối
//            Toast.makeText(this, "Connected to Internet", Toast.LENGTH_SHORT).show();
        } else {
            // Không có kết nối mạng
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again.")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
    private void put()
    {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent room=new Intent(TrangChu.this,Loai.class);
                room.putExtra("Ma",databaseReference.getRef().getKey());
                startActivity(room);
            }
        });
    }

}
