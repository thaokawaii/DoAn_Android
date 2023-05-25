package com.example.order_room.Activity;

import static com.example.order_room.R.id.datPhong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Model.HOADON;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("unchecked")
public class DatPhong extends AppCompatActivity {
    Button btn;
    EditText editText;
    EditText editText1;
    String DateNow;
    String MAKS,MAPH,MALOAI,MAKH;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);


        btn=findViewById(datPhong);
        chonNgay();
        DataLocalManager.init(getApplicationContext());
        User user= DataLocalManager.getUser();
        MAKH=user.getSDT();
        if(getIntent()!=null)
        {
            MAKS=getIntent().getStringExtra("MAKS");
            MALOAI=getIntent().getStringExtra("MALOAI");
            MAPH=getIntent().getStringExtra("MAPH");
        }
        if(! MAKS.isEmpty()&& MAKS!=null&&! MALOAI.isEmpty()&& MALOAI!=null&&! MAPH.isEmpty()&& MAPH!=null) {

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   try {
                       FirebaseDatabase database = FirebaseDatabase.getInstance();
                       DatabaseReference myRef = database.getReference("CTHOADON");
                       HOADON hd = new HOADON();
                       hd.setMAKH(MAKH);
                       hd.setMAKS(MAKS);
                       hd.setMALOAI(MALOAI);
                       hd.setMAPH(MAPH);
                       hd.setNGAYDAT(DateNow);
                       hd.setNGAYNHAN(editText.getText().toString());
                       hd.setNGAYTRA(editText1.getText().toString());
                       hd.setTINHTRANG("Chưa thanh toán");
                       hd.setTONGTIEN("20000000");
                       myRef.push().setValue(hd);
                       Toast.makeText(DatPhong.this, "Thành công", Toast.LENGTH_SHORT).show();
                   }
                   catch (Exception ex)
                   {
                       Toast.makeText(DatPhong.this, "Lỗi thấy bà gòi", Toast.LENGTH_SHORT).show();
                   }

                }
            });

        }


    }
    private void chonNgay()
    {


        editText=findViewById(R.id.chon_ngaynhan);
        editText1=findViewById(R.id.chon_ngaytra);
        editText.setKeyListener(null);
        editText1.setKeyListener(null);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        DateNow=day+"/"+month+"/"+year;
        long startDay = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        long endDay = calendar.getTimeInMillis();

        Pair<Long, Long> range = new Pair<>(startDay, endDay);
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("CHON NGAY NHAN TRA PHONG");
        MaterialDatePicker<Pair<Long, Long>> picker = builder.build();



        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show(getSupportFragmentManager(), picker.toString());
                picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {
                        Long f= selection.first;
                        Long e=selection.second;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        String startDateStr = sdf.format(f);
                        String endDateStr = sdf.format(e);
                        editText.setText(startDateStr);
                        editText1.setText(endDateStr);


                    }
                });
            }
        });

    }

}