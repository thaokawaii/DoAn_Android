package com.example.order_room.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.order_room.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class KhachSanAdapter extends BaseAdapter {
    private List<KHACHSAN> list;
    private Context context;

    public KhachSanAdapter(List<KHACHSAN> list, Context context) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_khachsan, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        KHACHSAN ks = (KHACHSAN) getItem(position);
       TextView name= viewProduct.findViewById(R.id.name_ks);
        name.setText(ks.getTENKS());
        ImageView imageView=viewProduct.findViewById(R.id.ks_image);
        Picasso.get().load(ks.getANH()).into(imageView);



        return viewProduct;
    }
}
