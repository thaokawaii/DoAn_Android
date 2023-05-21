package com.example.order_room.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.order_room.Model.KHACHHANG;
import com.example.order_room.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangKi extends AppCompatActivity {
ImageView imageView;
EditText ten,diachi,sdt,email,matkhau,xnpass;
    RadioGroup genderRadioGroup;
Button btn;
final int gt=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        anhxa();
        dangnhap();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DangKi.this,DangNhap.class);
                startActivity(i);
            }
        });
    }

    private void anhxa() {
        imageView=findViewById(R.id.back_DN);
        ten=findViewById(R.id.name);
        diachi=findViewById(R.id.adress);
        sdt=findViewById(R.id.numberPhone);
        matkhau=findViewById(R.id.passWord);
        email=findViewById(R.id.email);
        xnpass=findViewById(R.id.xnpass);
        btn=findViewById(R.id.btn_DK);
      genderRadioGroup = findViewById(R.id.genderRadioGroup);


    }
    void dangnhap()
    {
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_kh = firebaseDatabase.getReference("KHACHHANG");
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final ProgressDialog dialog=new ProgressDialog(DangKi.this);
                dialog.setMessage("Please Waiting....");
                dialog.show();
                table_kh.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(kiemtra()==true)
                        {
                            if(snapshot.child(sdt.getText().toString()).exists()) {
                                dialog.dismiss();
                                Toast.makeText(DangKi.this, "Số điện thoại đã được đăng ký", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                dialog.dismiss();
                                KHACHHANG kh=new KHACHHANG(diachi.getText().toString(),email.getText().toString(),traveGT(),ten.getText().toString(),matkhau.getText().toString(),sdt.getText().toString());
                                table_kh.child(sdt.getText().toString()).setValue(kh);
                                Toast.makeText(DangKi.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(DangKi.this,TrangChu.class);
                                startActivity(i);
                                finish();


                            }
                        }
                        else
                        {
                            Toast.makeText(DangKi.this, "Hãy nhập đầy đủ", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    Boolean kiemtra()
    {
        if(email.getText().length()==0||diachi.getText().length()==0||ten.getText().length()==0||sdt.getText().length()==0||matkhau.getText().length()==0||xnpass.getText().length()==0)
        {
            return false;
        }
        else {
            return true;
        }
    }
    private String traveGT()
    {
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String gender = selectedRadioButton.getText().toString();
        return gender;
    }
}