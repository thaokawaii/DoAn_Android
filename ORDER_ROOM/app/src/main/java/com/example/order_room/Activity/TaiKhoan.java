package com.example.order_room.Activity;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Adapter.KhachHangAdapter;
import com.example.order_room.Adapter.KhachSanAdapter;
import com.example.order_room.Model.KHACHHANG;
import com.example.order_room.Model.KHACHSAN;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.cache.DiskLruCache;

public class TaiKhoan extends AppCompatActivity {
 ImageView imageView;
    ArrayList<KHACHHANG> list=new ArrayList<>();
    String MAKH,MK;
    TextView ten;
    TextView sdt;
    TextView gt;
   TextView diachi;
    TextView matkhau;
    TextView email;
    EditText passmoi;
    Button btn;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);

      ten=findViewById(R.id.taikhoan_ten);
        sdt=findViewById(R.id.taikhoan_sdt);
       gt=findViewById(R.id.taikhoan_GT);
       diachi=findViewById(R.id.taikhoan_diachi);
        matkhau=findViewById(R.id.taikhoan_passcu);
      email=findViewById(R.id.taikhoan_email);
       passmoi=findViewById(R.id.taikhoan_passnew);
      btn=findViewById(R.id.taikhoan_btn_DK);
        imageView=findViewById(R.id.back_TC);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TaiKhoan.this,TrangChu.class);
                startActivity(i);
            }
        });

        DataLocalManager.init(getApplicationContext());
        User user= DataLocalManager.getUser();
        MAKH=user.getSDT();
        MK=user.getMATKHAU();
    KhachHangAdapter khachHangAdapter= new KhachHangAdapter( list,this);

dangnhap();
chon();


    }
    void dangnhap()
    {
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_kh = firebaseDatabase.getReference("KHACHHANG");
                    table_kh.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if (snapshot.child(MAKH.toString()).exists()) {
                                    KHACHHANG kh = snapshot.child(MAKH).getValue(KHACHHANG.class);
                                    if (kh.getMATKHAU().equals(MK)) {
                                       list.add(kh);

//                                        Toast.makeText(TaiKhoan.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    }

                                }else {
                                    Toast.makeText(TaiKhoan.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                                }
                                for(KHACHHANG k:list)
                                {
                                    ten.setText(k.getHOTEN().toString());
                                    diachi.setText(k.getDIACHI().toString());
                                    sdt.setText(k.getSDT().toString());
                                    gt.setText(k.getGT());
                                    email.setText(k.getEMAIL());
                                    matkhau.setText(k.getMATKHAU());
                              

                                }



                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                public void chon()
                {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                            final DatabaseReference table_kh = firebaseDatabase.getReference();
                           table_kh.child("KHACHHANG").child(MAKH).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                   if(kt()==false) {

                                       Toast.makeText(TaiKhoan.this, "Chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();

                                   }
                                   else {
                                       DatabaseReference nodeRef = snapshot.getRef();

                                       nodeRef.child("MATKHAU").setValue(passmoi.getText().toString());
                                       DataLocalManager.init(getApplicationContext());
                                       User user= DataLocalManager.getUser();
                                       DataLocalManager.remove(user);
                                       User user1=new User(passmoi.getText().toString(),sdt.getText().toString());
                                       DataLocalManager.setUser(user1);
                                       Toast.makeText(TaiKhoan.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                                   }

                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });




                        }
                    });
                }
                private boolean kt()
                {
                    if(diachi.getText().length()==0&&email.getText().length()==0&&passmoi.getText().length()==0)
                    {
                        return false;
                    }
                    else {
                        return true;
                    }
                }

}