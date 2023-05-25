package com.example.order_room.Adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.order_room.Activity.Phong;
import com.example.order_room.Model.LOAIPHONG;
import com.example.order_room.Model.PHONG;
import com.example.order_room.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PhongAdapter extends BaseAdapter {
    private ArrayList<PHONG> list_ph;
    private Context context;

    public PhongAdapter(ArrayList<PHONG> list_ph, Context context) {
        this.list_ph = list_ph;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_ph.size();
    }

    @Override
    public Object getItem(int position) {
        return list_ph.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_phong, null);
        } else viewProduct = convertView;

        ImageView imageView=viewProduct.findViewById(R.id.image_room);
        TextView name=viewProduct.findViewById(R.id.ten_room);
        TextView mota=viewProduct.findViewById(R.id.mota_room);
        TextView tinhtrang=viewProduct.findViewById(R.id.tinhtrang_room);

           PHONG ph= (PHONG) getItem(position);
    name.setText(ph.getTENPH());
    mota.setText(ph.getMOTA());
    tinhtrang.setText(ph.getTINHTRANG());


        Picasso.get().load(ph.getANH()).into(imageView);





        return viewProduct;
    }
}
