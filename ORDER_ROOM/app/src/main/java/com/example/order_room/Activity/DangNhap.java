package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Model.KHACHHANG;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangNhap extends AppCompatActivity {
Button btnDN,btnDK;
EditText email,pass;
ImageView hien;
    boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhxa();
        dangnhap();
        dangky();


   hien.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (!isPasswordVisible) {
           pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            isPasswordVisible = true;
        } else {
           pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            isPasswordVisible = false;
        }
    }
});




    }

    private void dangky() {
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DangNhap.this,DangKi.class);
                startActivity(i);
            }
        });
    }

    void anhxa()
    {
        btnDN = findViewById(R.id.Login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btnDK=findViewById(R.id.register);
        hien=findViewById(R.id.hienpass);
    }
    void dangnhap()
    {
        DataLocalManager.init(getApplicationContext());
        User user= DataLocalManager.getUser();

        if(user!=null)
        {
            Log.e("Ten",user.toString());
            pass.setText(user.getMATKHAU());
            email.setText(user.getSDT());
          Intent intent=new Intent(DangNhap.this,TrangChu.class);
          startActivity(intent);


        }
        else {
            final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            final DatabaseReference table_kh = firebaseDatabase.getReference("KHACHHANG");
            btnDN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final ProgressDialog dialog = new ProgressDialog(DangNhap.this);
                    dialog.setMessage("Please Waiting....");
                    table_kh.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (kiemtra() == true) {
                                if (snapshot.child(email.getText().toString()).exists()) {
                                    KHACHHANG kh = snapshot.child(email.getText().toString()).getValue(KHACHHANG.class);
                                    if (kh.getMATKHAU().equals(pass.getText().toString())) {
                                        User user1=new User(pass.getText().toString(),email.getText().toString());
                                        DataLocalManager.setUser(user1);
                                        dialog.show();
                                        Intent intent = new Intent(DangNhap.this, TrangChu.class);
                                        startActivity(intent);
                                        Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(DangNhap.this, "Thất bại", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(DangNhap.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(DangNhap.this, "Hãy nhập đầy đủ", Toast.LENGTH_SHORT).show();
                            }


                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });
        }
    }
    Boolean kiemtra()
    {
        if(email.getText().length()==0||pass.getText().length()==0)
        {
            return false;
        }
        else {
            return true;
        }
    }

}