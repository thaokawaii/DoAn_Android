package com.example.order_room.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class ChonNgay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngay);
// DataLocalManager.init(getApplicationContext());
//        User user=new User("thao123","0935841425");
//        DataLocalManager.setUser(user);

        Button btn=findViewById(R.id.btn_thu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChonNgay.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}