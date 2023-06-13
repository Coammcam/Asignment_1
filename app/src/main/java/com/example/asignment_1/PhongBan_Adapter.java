package com.example.asignment_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhongBan_Adapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<PhongBan> phongban;

    public PhongBan_Adapter(Context context, ArrayList<PhongBan> phongban) {
        this.context = context;
        this.phongban = phongban;
    }



    @Override
    public int getCount() {
        return phongban.size();
    }

    @Override
    public Object getItem(int position) {
        return phongban.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_phongban, parent, false);
        ImageView logo_phongban = convertView.findViewById(R.id.logo_phongban);
        TextView name_phongban = convertView.findViewById(R.id.name_phongban);
        logo_phongban.setImageResource(phongban.get(position).getLogo_phongban());
        name_phongban.setText(phongban.get(position).getName_phongban());
        return convertView;
    }
}
