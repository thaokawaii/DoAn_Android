package com.example.order_room.Adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_room.Model.LOAIPHONG;
import com.example.order_room.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class LoaiPhongAdapter extends BaseAdapter {
    private List<LOAIPHONG> list;
    private Context context;

    @Override
    public int getCount() {
        return list.size();
    }

    public LoaiPhongAdapter(List<LOAIPHONG> list, Context context) {
        this.list = list;
        this.context = context;
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
            viewProduct = View.inflate(parent.getContext(), R.layout.item_loaiphong, null);
        } else viewProduct = convertView;

        Locale locale = new Locale("vi", "VN"); // định dạng tiền tệ theo địa phương Việt Nam
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);

        LOAIPHONG ks = (LOAIPHONG) getItem(position);
        TextView gia= viewProduct.findViewById(R.id.gia_loaiPhong);
        TextView name=viewProduct.findViewById(R.id.ten_loaiphong);
        TextView mota=viewProduct.findViewById(R.id.mota_loaiphong);
        TextView songuoi=viewProduct.findViewById(R.id.songuoi);
        ImageView imageView=viewProduct.findViewById(R.id.image_loaiphong);
         gia.setText(decimalFormat.format(Integer.valueOf(ks.getGIA())));
         name.setText(ks.getTENLOAI());
         mota.setText(ks.getMOTA());
         songuoi.setText(ks.getSONGUOITOIDA());
        Picasso.get().load(ks.getANH()).into(imageView);




        return viewProduct;
    }

}
