package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Adapter.HoaDonAdapter;
import com.example.order_room.Adapter.KhachSanAdapter;
import com.example.order_room.Model.HOADON;
import com.example.order_room.Model.KHACHSAN;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonDat extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    NavigationView navigationView;




    ListView listView;
String MAKH;

    ArrayList<HOADON> list=new ArrayList<>();
    private DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_dat);

      menu();

        DataLocalManager.init(getApplicationContext());
        User user= DataLocalManager.getUser();
        MAKH=user.getSDT();
        listView = findViewById(R.id.list_hd);
        HoaDonAdapter hoaDonAdapter = new HoaDonAdapter( list,this);
        databaseReference = FirebaseDatabase.getInstance().getReference("CTHOADON");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                   HOADON item = dataSnapshot.getValue(HOADON.class);
                   if(item.getMAKH().equals(MAKH)&&item.getTINHTRANG().equals("Chưa thanh toán")) {
                       list.add(item);
                   }

                    load();
                }
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        HOADON ks= (HOADON) hoaDonAdapter.getItem(position);
//                        Intent intent=new Intent(DonDat.this,Phong.class);
//                        intent.putExtra("MAKS",ks.getMAKS());
//                        intent.putExtra("MALOAI",ks.getMALOAI());
//                        startActivity(intent);
//
//                    }
//                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

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
                        DataLocalManager.init(getApplicationContext());
                        User user= DataLocalManager.getUser();
                        DataLocalManager.remove(user);
                        Toast.makeText(DonDat.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                        Intent y=new Intent(DonDat.this,DangNhap.class);
                        startActivity(y);

                        return true;
                    case R.id.user:
                        Toast.makeText(DonDat.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                        Intent v=new Intent(DonDat.this,TaiKhoan.class);
                        startActivity(v);
                        return true;

                }
                return false;
            }
        });
    }
    private void load() {



       HoaDonAdapter hoaDonAdapter = new HoaDonAdapter(list,this);

        listView = findViewById(R.id.list_hd);
        listView.setAdapter(hoaDonAdapter);

    }
}