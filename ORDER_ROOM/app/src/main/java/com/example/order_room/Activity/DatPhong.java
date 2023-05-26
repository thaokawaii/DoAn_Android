package com.example.order_room.Activity;

import static com.example.order_room.R.id.datPhong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_room.Adapter.DataLocalManager;
import com.example.order_room.Adapter.PhongAdapter;
import com.example.order_room.Model.HOADON;
import com.example.order_room.Model.PHONG;
import com.example.order_room.Model.User;
import com.example.order_room.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class DatPhong extends AppCompatActivity {
    Button btn;
    EditText editText;
    EditText editText1;
    String DateNow;
    String MAKS,MAPH,MALOAI,MAKH;
    String Tong;
    int tongtien;
    TextView tong;
    ImageView back;
    TextView ngaynhan;
    TextView ngaytra;

    ListView listView;
    private DatabaseReference databaseReference;

    ArrayList<PHONG> list_phong=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);

        ngaynhan=findViewById(R.id.chon_ngaynhan);
        ngaytra=findViewById(R.id.chon_ngaytra);

       back=findViewById(R.id.back_dondat);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(DatPhong.this,DonDat.class);
               startActivity(intent);
           }
       });
        tong=findViewById(R.id.tongTien);
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
        gia();
        if(! MAKS.isEmpty()&& MAKS!=null&&! MALOAI.isEmpty()&& MALOAI!=null&&! MAPH.isEmpty()&& MAPH!=null) {

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(ngaynhan.getText().length()==0||ngaytra.getText().length()==0)
              {
                  thongbao();
              }
              else {
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
                      hd.setTONGTIEN(tong.getText().toString());
                      myRef.push().setValue(hd);

                      Toast.makeText(DatPhong.this, "Thành công", Toast.LENGTH_SHORT).show();
                  } catch (Exception ex) {
                      Toast.makeText(DatPhong.this, "Lỗi thấy bà gòi", Toast.LENGTH_SHORT).show();
                  }
              }

          }
      });


        }
        loadRoom();

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
                        long duration = -(f - e);


                        int daysBetween = (int) TimeUnit.MILLISECONDS.toDays(duration);

                        String str=tong.getText().toString();
                        Log.e("Tong ngay:",String.valueOf(daysBetween));
                        Log.e("Tien:",str);
                       int giatri=Integer.parseInt(str);
                       tongtien=daysBetween*giatri;

                     tong.setText( travedangtien(tongtien));
                        Toast.makeText(DatPhong.this, "Số ngày bạn đặt là:"+String.valueOf(daysBetween), Toast.LENGTH_SHORT).show();



                    }
                });
            }
        });

    }
    public void gia()
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("LOAIPHONG");
        Query query = ref.orderByChild("MALOAI").equalTo(MALOAI);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                        if(childSnapshot.child("MAKS").getValue(String.class).equals(MAKS)&&childSnapshot.child("MALOAI").getValue(String.class).equals(MALOAI)) {
                            tong.setText(childSnapshot.child("GIA").getValue(String.class));
                            String salary = childSnapshot.child("GIA").getValue(String.class);
                            Log.e("TAG", "Tien" + salary);

                            Tong=salary;
                        }

                    }
                } else {
                    Log.d("TAG", "No employee with name John and city New York found.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });

    }
    private String travedangtien(int number)
    {

        NumberFormat format = NumberFormat.getInstance(Locale.US);
        format.setGroupingUsed(true);
        String result = format.format(number);
        return result;
    }
    private void loadRoom()
    {
        if(getIntent()!=null)
        {
            MAKS=getIntent().getStringExtra("MAKS");
            MALOAI=getIntent().getStringExtra("MALOAI");
            MAPH=getIntent().getStringExtra("MAPH");
        }
        if(!MAKS.isEmpty()&&MAKS!=null&&!MALOAI.isEmpty()&&MALOAI!=null) {

            PhongAdapter Adapter = new PhongAdapter(list_phong, this);
            databaseReference = FirebaseDatabase.getInstance().getReference("PHONG");


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        PHONG item = dataSnapshot.getValue(PHONG.class);
                        if (item.getMAKS().equals(MAKS) && item.getMALOAI().equals(MALOAI)&&item.getMAPHONG().equals(MAPH)) {

                            if(item.getTINHTRANG().equals("0"))
                            {
                                TextView tinhtrang=findViewById(R.id.tinhtrang_room);

                            }
                            list_phong.add(item);

                            load();
                        }
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }
    }
    private void load() {



        PhongAdapter Adapter = new PhongAdapter(list_phong,this);

        listView = findViewById(R.id.list_ct);
        listView.setAdapter(Adapter);

    }
    public void thongbao()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("Thông báo lỗi");
        builder.setMessage("Không được để trống ngày nhận trả phòng");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }
}