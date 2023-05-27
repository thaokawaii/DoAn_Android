package com.example.order_room.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.order_room.Model.HOADON;
import com.example.order_room.Model.KHACHHANG;
import com.example.order_room.R;

import java.util.ArrayList;

public class KhachHangAdapter extends BaseAdapter {
    ArrayList<KHACHHANG> list;
    Context  context;

    public KhachHangAdapter(ArrayList<KHACHHANG> list, Context context) {
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
            viewProduct = View.inflate(parent.getContext(), R.layout.activity_tai_khoan, null);
        } else viewProduct = convertView;

      KHACHHANG kh = (KHACHHANG) getItem(position);
        TextView ten=viewProduct.findViewById(R.id.taikhoan_ten);
        TextView sdt=viewProduct.findViewById(R.id.taikhoan_sdt);
        TextView gt=viewProduct.findViewById(R.id.taikhoan_GT);
        EditText diachi=viewProduct.findViewById(R.id.taikhoan_diachi);
        EditText matkhau=viewProduct.findViewById(R.id.taikhoan_passcu);
        EditText email=viewProduct.findViewById(R.id.taikhoan_email);
        EditText passmoi=viewProduct.findViewById(R.id.taikhoan_passnew);
        Button btn=viewProduct.findViewById(R.id.taikhoan_btn_DK);
        return viewProduct;
    }
}
