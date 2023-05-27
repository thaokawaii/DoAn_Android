package com.example.order_room.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.order_room.Activity.DonDat;
import com.example.order_room.Activity.Phong;
import com.example.order_room.Model.HOADON;
import com.example.order_room.Model.KHACHSAN;
import com.example.order_room.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HoaDonAdapter extends BaseAdapter {
    ArrayList<HOADON> list;
    Context context;
    ListView listView;

    public HoaDonAdapter(ArrayList<HOADON> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.chitiet_dondat, null);
        } else viewProduct = convertView;

        HOADON hd = (HOADON) getItem(position);
        TextView ma= viewProduct.findViewById(R.id.MaKS);
        TextView ngaynh=viewProduct.findViewById(R.id.ngayD);
        TextView ngaytr=viewProduct.findViewById(R.id.ngaytr);
        TextView sdt=viewProduct.findViewById(R.id.SDT_nguoidat);
        sdt.setText(hd.getMAKH());

       ma.setText(hd.getMAKS());
        ngaynh.setText(hd.getNGAYDAT());
        ngaytr.setText(hd.getNGAYTRA());
        TextView tien=viewProduct.findViewById(R.id.money);
        tien.setText(hd.getTONGTIEN());
        ImageView  cancelButton=viewProduct.findViewById(R.id.delete);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc muốn hủy đơn đặt?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("CTHOADON");


                                databaseReference.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                            HOADON item = dataSnapshot.getValue(HOADON.class);
                                            if(item.getMAKH().equals(hd.getMAKH())&&item.getMAKS().equals(hd.getMAKS())&&item.getMALOAI().equals(hd.getMALOAI())&&item.getMAPH().equals(hd.getMAPH())) {
                                                dataSnapshot.getRef().removeValue();
                                                HoaDonAdapter.this.list.remove(position);
                                                HoaDonAdapter.this.notifyDataSetChanged();


                                                Toast.makeText(context, "Hủy đơn thành công", Toast.LENGTH_SHORT).show();
                                            }


                                        }


                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }


                                });

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });




        return viewProduct;
    }

}
