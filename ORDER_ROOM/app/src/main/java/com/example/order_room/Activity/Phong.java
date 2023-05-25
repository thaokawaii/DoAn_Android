package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.order_room.Adapter.KhachSanAdapter;
import com.example.order_room.Adapter.LoaiPhongAdapter;
import com.example.order_room.Adapter.PhongAdapter;
import com.example.order_room.Model.KHACHSAN;
import com.example.order_room.Model.LOAIPHONG;
import com.example.order_room.Model.PHONG;
import com.example.order_room.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Phong extends AppCompatActivity {
    ListView listView;
    String MaKs="";
    String MaLoai="";

    ArrayList<PHONG> list_phong=new ArrayList<>();
    ImageView imageView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong);
imageView=findViewById(R.id.back_loaiph);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Phong.this,Loai.class);
        startActivity(intent);
    }
});
        loadRoom();
    }

    private void loadRoom()
    {
        if(getIntent()!=null)
        {
            MaKs=getIntent().getStringExtra("MAKS");
            MaLoai=getIntent().getStringExtra("MALOAI");
        }
        if(!MaKs.isEmpty()&&MaKs!=null&&!MaLoai.isEmpty()&&MaLoai!=null) {
            Log.e("ma", MaKs);
            Log.e("maloai",MaLoai);
            PhongAdapter Adapter = new PhongAdapter(list_phong, this);
            databaseReference = FirebaseDatabase.getInstance().getReference("PHONG");


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        PHONG item = dataSnapshot.getValue(PHONG.class);
                        if (item.getMAKS().equals(MaKs) && item.getMALOAI().equals(MaLoai)) {


                            list_phong.add(item);

                            load();
                        }
                    }
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            PHONG ks= (PHONG) Adapter.getItem(position);
                            Intent intent=new Intent(Phong.this,DatPhong.class);
                                intent.putExtra("MAKS",MaKs);
                                intent.putExtra("MALOAI",MaLoai);
                                intent.putExtra("MAPH",ks.getMAPHONG());
                                Log.e("KKKKK:",ks.getMAPHONG()+MaLoai+MaKs);
                            startActivity(intent);
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }
    }
    private void load() {



      PhongAdapter Adapter = new PhongAdapter(list_phong,this);

        listView = findViewById(R.id.list_phong);
        listView.setAdapter(Adapter);

    }


}

