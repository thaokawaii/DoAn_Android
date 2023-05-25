package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_room.Adapter.KhachSanAdapter;
import com.example.order_room.Adapter.LoaiPhongAdapter;
import com.example.order_room.Model.KHACHHANG;
import com.example.order_room.Model.KHACHSAN;
import com.example.order_room.Model.LOAIPHONG;
import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Loai extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    ListView listView;
    String Ma="";

    NavigationView navigationView;
    List<LOAIPHONG> list=new ArrayList<>();
    ImageView imageView;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai);
imageView=findViewById(R.id.back_tragchu);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Loai.this,TrangChu.class);
        startActivity(intent);
    }
});
       loadLoai();


    }



    private void load() {



       LoaiPhongAdapter loaiPhongAdapter = new LoaiPhongAdapter(list,this);

        listView = findViewById(R.id.list_loaiphong);
        listView.setAdapter(loaiPhongAdapter);

    }
    private void loadLoai()
    {
        if(getIntent()!=null)
        {
            Ma=getIntent().getStringExtra("Ma");
        }
        if(!Ma.isEmpty()&&Ma!=null) {
            Log.e("ma",Ma);

            LoaiPhongAdapter productAdapter = new LoaiPhongAdapter(list, this);
            databaseReference = FirebaseDatabase.getInstance().getReference("LOAIPHONG");


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        LOAIPHONG item = dataSnapshot.getValue(LOAIPHONG.class);
                        if (item.getMAKS().equals(Ma)) {


                            list.add(item);

                            load();
                        }
                    }
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            LOAIPHONG ks = (LOAIPHONG) productAdapter.getItem(position);
                            Intent maks=new Intent(Loai.this,Phong.class);
                            maks.putExtra("MAKS",Ma);
                            maks.putExtra("MALOAI",ks.getMALOAI());
                            startActivity(maks);

                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }

    }
}